package com.zhilv.audit.travels.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.annotations.Case;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhilv.audit.travels.service.AuditTravelsService;
import com.zhilv.entity.AuditTravels;
import com.zhilv.entity.Img;
import com.zhilv.entity.MoreDetail;
import com.zhilv.entity.Topic;
import com.zhilv.entity.Travels;
import com.zhilv.entity.User;
import com.zhilv.travels.service.TravelsService;
import com.zhilv.util.DateUtil;
import com.zhilv.util.FinalUtil;
import com.zhilv.util.Page;

import sun.awt.image.ImagingLib;

/**   
 * @ClassName: AuditTravelsController   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月20日 下午4:55:26       
 */
@Controller
@RequestMapping("audit/travels")
public class AuditTravelsController {
	@Resource
	private AuditTravelsService auditTravelsService;
	
	@Resource
	private TravelsService travelsService;
	
	@RequestMapping(value="/list/{pageNum}",method=RequestMethod.GET)
	public String list(@PathVariable(value="pageNum",required=true)int pageNum, Model model) {
		List<AuditTravels> list = auditTravelsService.findForPage((pageNum-1)*FinalUtil.PAGE_SIZE, FinalUtil.PAGE_SIZE);
		Page<AuditTravels> page = new Page<>(pageNum,3);
		page.setList(list);
		page.setTotalCount(auditTravelsService.findTravelsCount());
		model.addAttribute("travelsPage",page);
		return "index";
	}
	
	/**
	 * @Title: add
	 * @Description:
	 * @先插入detail获取moreId
	 * @再插入travels ,赋值moreId,获取travelsId
	 * @最后插入img,赋值travelsId
	 * @最后更新detail的travelsID
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	public String add(HttpServletRequest request) {
		String str = "";
		AuditTravels auditTravels = new AuditTravels();
		MoreDetail moreDetail = new MoreDetail();
		List<Img> imgList = new ArrayList<>();
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem fi : items) {
				if(fi.isFormField()) {
					String string = fi.getString("utf-8");
					switch (fi.getFieldName()) {
						case "travelsId":
							auditTravels.setTravelsId(Integer.parseInt(string));
							break;
						case "title":
							auditTravels.setTitle(string);
							break;
						case "route":
							auditTravels.setRoute(string);
							break;
						case "scene":
							auditTravels.setScene(string);
							break;
						case "ticket":
							auditTravels.setTicket(string);
							break;
						case "hotel":
							auditTravels.setHotel(string);
							break;
						case "tips":
							auditTravels.setTips(string);
							break;
						case "topicId":
							Topic topic = new Topic();
							topic.setTopicId(Integer.parseInt(string));
							auditTravels.setTopic(topic);
							break;
						case "location":
							auditTravels.setLocation(string);
							break;
						case "destination":
							moreDetail.setDestination(string);
							break;
						case "traffic":
							moreDetail.setTraffic(string);
							break;		
						case "beginDate":
							moreDetail.setBeginDate(DateUtil.getDate(string));					
							break;
						case "days":
							moreDetail.setDays(Integer.parseInt(string));
							break;
						case "people":
							moreDetail.setPeople(string);
							break;
						case "money":
							moreDetail.setMoney(Integer.parseInt(string));
							break;
						case "userId":
							auditTravels.setUserId(Integer.parseInt(string));
							break;
						case "httpImg":
							Img img = new Img();
							int k = string.lastIndexOf("/",string.lastIndexOf("/")-1)+1;//倒数第二个“/”
							img.setPath(string.substring(k));
							imgList.add(img);
							break;
						default:
							break;
					}
				}else {
					Img img = new Img();
					String realPath = request.getSession().getServletContext().getRealPath("/");
					fi.write(new File(realPath+"image\\"+fi.getName()));
					img.setPath("image/"+fi.getName());
					imgList.add(img);
				}
			}
			auditTravels.setUploadTime(DateUtil.getCurrentTimes());
			System.out.println(auditTravels);
			int i = auditTravelsService.addTravelsDetail(moreDetail);//获取返回moreId
			auditTravels.setDetail(moreDetail);
			i += auditTravelsService.addAuditTravels(auditTravels);//获取travelsId
			if(imgList.size() > 0) {
				for(Img img:imgList) {
					img.setTravelsId(auditTravels.getAuditId());
				}
				i+= auditTravelsService.addTravelsImg(imgList);
			}
			i+= auditTravelsService.updateDetailTravelsIdById(auditTravels.getAuditId(), moreDetail.getMoreId());
			if(i >= 3) {
				str = "OK";
				System.out.println("审核版游记添加成功");
			}else {
				str = "ERROR";
				System.out.println("审核版游记添加失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return str;
	}
	/**
	 * @ 如果travelsId=null,则添加即可,否则查找指定游记并更新
	 */
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String update(@RequestParam("auditId")Integer auditId,@RequestParam("status")Integer status) {
		int i = auditTravelsService.updateTravelsStatus(auditId, status, DateUtil.getCurrentTimes());
		if(i > 0) {
			System.out.println("审核版游记状态更新成功");
			if(status == 1) {
				String str = null;
				AuditTravels auditTravels = auditTravelsService.findAuditTravelsById(auditId);
				Travels travels = new Travels();
				travels.setTravelsId(auditTravels.getTravelsId());
				travels.setHotel(auditTravels.getHotel());
				travels.setLocation(auditTravels.getLocation());
				travels.setRoute(auditTravels.getRoute());
				travels.setScene(auditTravels.getScene());
				travels.setTicket(auditTravels.getTicket());
				travels.setTips(auditTravels.getTips());
				travels.setTitle(auditTravels.getTitle());
				travels.setTopic(auditTravels.getTopic());
				travels.setUploadTime(auditTravels.getUploadTime());
				User user = new User();
				user.setUserId(auditTravels.getUserId());
				travels.setUser(user);
				if(null == auditTravels.getTravelsId()) { //添加游记
					MoreDetail moreDetail = auditTravels.getDetail();
					int j = travelsService.addTravelsDetail(moreDetail);
					travels.setDetail(moreDetail);
					j += travelsService.addTravels(travels);
					if(null != auditTravels.getImgList().get(0).getImgId()) {
						for(Img img:auditTravels.getImgList()) {
							img.setTravelsId(travels.getTravelsId());
						}
						j += travelsService.addTravelsImg(auditTravels.getImgList());
					}
					j += travelsService.updateDetailTravelsIdById(travels.getTravelsId(), moreDetail.getMoreId());
					if(j >= 3) {
						str = "OK";
						System.out.println("发布版游记添加成功");
					}else {
						str = "ERROR";
						System.out.println("发布版游记添加失败");
					}
				}else {                                   //编辑游记
					//修改travels_detail
					int j = travelsService.updateTravelsById(travels);
					//修改more_detail
					auditTravels.getDetail().setTravelsId(auditTravels.getTravelsId());
					j += travelsService.updateTravelsDetail(auditTravels.getDetail());
					//修改travels_img
					List<Img> newImgs = auditTravels.getImgList();
					List<Img> oldImgs = travelsService.findImgByTravelsId(auditTravels.getTravelsId());
					//编辑前图片如果不存在就删除
					for(Img oldImg:oldImgs) {
						boolean b = false;
						for(Img newImg:newImgs) {
							if(newImg.getPath().equals(oldImg.getPath())) {//路径相同,不需要更新
								newImgs.remove(newImg);   
								b = true; //已找到
								break;
							}
						}
						if(!b) {    //未找到路径,删除图片
							j += travelsService.deleteImgById(oldImg.getImgId());
							System.out.println("删除图片路径"+oldImg.getPath());
						}
					}
					//改变travelsId,并插入新增的图片
					if(newImgs.size() > 0) {
						for(Img img:newImgs) {
							img.setTravelsId(auditTravels.getTravelsId());
						}
						j += travelsService.addTravelsImg(newImgs);
					}
					System.out.println("j="+j);
					if(j > 0) {
						str = "OK";
						System.out.println("发布版游记编辑成功");
					}else {
						str = "ERROR";
						System.out.println("发布版游记编辑失败");
					}
				}
			}
			return "redirect:list/1";
		}else {
			System.out.println("审核版游记状态更新失败");
			return "redirect:list/1";
		}
	}
	
}
