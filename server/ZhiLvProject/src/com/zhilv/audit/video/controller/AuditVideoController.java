package com.zhilv.audit.video.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhilv.audit.video.service.AuditVideoService;
import com.zhilv.entity.AuditVideo;
import com.zhilv.entity.MoreDetail;
import com.zhilv.entity.Topic;
import com.zhilv.entity.User;
import com.zhilv.entity.Video;
import com.zhilv.util.DateUtil;
import com.zhilv.util.FinalUtil;
import com.zhilv.util.Page;
import com.zhilv.video.service.VideoService;

/**   
 * @ClassName: VideoController   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月25日 上午11:03:22       
 */
@Controller
@RequestMapping("/audit/video")
public class AuditVideoController {
	
	@Resource
	private AuditVideoService auditVideoService;
	
	@Resource
	private VideoService videoService;
	
	@RequestMapping(value="/list/{pageNum}",method=RequestMethod.GET)
	public String list(@PathVariable(value="pageNum",required=true)int pageNum,Model model) {
		List<AuditVideo> list = auditVideoService.findForPage((pageNum-1)*FinalUtil.PAGE_SIZE, FinalUtil.PAGE_SIZE);
		Page<AuditVideo> page = new Page<>(pageNum,FinalUtil.PAGE_SIZE);
		page.setList(list);
		page.setTotalCount(auditVideoService.findVideoCount());
		model.addAttribute("videoPage",page);
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	public String add(HttpServletRequest request) {
		String str = "";
		AuditVideo auditVideo = new AuditVideo();
		MoreDetail moreDetail = new MoreDetail();
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem fi : items) {
				if(fi.isFormField()) {
					String string = fi.getString("utf-8");
					switch (fi.getFieldName()) {
						case "videoId":
							auditVideo.setVideoId(Integer.parseInt(string));
							break;
						case "title":
							auditVideo.setTitle(string);
							break;
						case "content":
							auditVideo.setContent(string);
							break;
						case "topicId":
							Topic topic = new Topic();
							topic.setTopicId(Integer.parseInt(string));
							auditVideo.setTopic(topic);
							break;
						case "location":
							auditVideo.setLocation(string);
							break;
						case "duration":
							auditVideo.setDuration(string);
							break;
						case "size":
							auditVideo.setSize(string);
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
							auditVideo.setUserId(Integer.parseInt(string));
							break;
						default:
							break;
					}
				}else {
					String realPath = request.getSession().getServletContext().getRealPath("/");
					if(fi.getName().contains(".mp4")) {
						fi.write(new File(realPath+"video\\"+fi.getName()));
						auditVideo.setPath("video/"+fi.getName());
					}else {
						fi.write(new File(realPath+"videoimg\\"+fi.getName()));
						auditVideo.setImg("videoimg/"+fi.getName());
					}
				}
			}
			auditVideo.setUploadTime(DateUtil.getCurrentTimes());
			int i = auditVideoService.addVideoDetail(moreDetail);//获取返回moreId
			auditVideo.setDetail(moreDetail);
			i += auditVideoService.addAuditVideo(auditVideo);//获取videoId
			i += auditVideoService.updateDetailVideoIdById(auditVideo.getAuditId(), moreDetail.getMoreId());
			if(i >= 3) {
				str = "OK";
				System.out.println("审核版视频添加成功");
			}else {
				str = "ERROR";
				System.out.println("审核版视频添加失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return str;
	}

	@ResponseBody
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String update(@RequestParam("auditId")Integer auditId,@RequestParam("status")Integer status) {
		int i = auditVideoService.updateVideoStatus(auditId, status, DateUtil.getCurrentTimes());
		String str = "OK";
		if(i > 0) {
			System.out.println("审核版视频状态更新成功");
			if(status == 1) {
				AuditVideo auditVideo = auditVideoService.findAuditVideoById(auditId);
				Video video = new Video();
				video.setVideoId(auditVideo.getVideoId());
				video.setContent(auditVideo.getContent());
				video.setDuration(auditVideo.getDuration());
				video.setImg(auditVideo.getImg());
				video.setLocation(auditVideo.getLocation());
				video.setPath(auditVideo.getPath());
				video.setSize(auditVideo.getSize());
				video.setTitle(auditVideo.getTitle());
				video.setTopic(auditVideo.getTopic());
				video.setUploadTime(auditVideo.getUploadTime());
				User user = new User();
				user.setUserId(auditVideo.getUserId());
				video.setUser(user);
				if(null == auditVideo.getVideoId()) { 
					MoreDetail moreDetail = auditVideo.getDetail();
					int j = videoService.addVideoDetail(moreDetail);
					video.setDetail(moreDetail);
					j += videoService.addVideo(video);
					j += videoService.updateDetailVideoIdById(video.getVideoId(), moreDetail.getMoreId());
					if(j >= 3) {
						System.out.println("发布版视频添加成功");
					}else {
						str = "ERROR";
						System.out.println("发布版视频添加失败");
					}
				}else {  //编辑视频
					int j = videoService.updateVideoById(video);
					auditVideo.getDetail().setVideoId(auditVideo.getVideoId());
					j += videoService.updateVideoDetail(auditVideo.getDetail());
					if(j > 0) {
						System.out.println("发布版视频编辑成功");
					}else {
						str = "ERROR";
						System.out.println("发布版视频编辑失败");
					}
				}
			}
		}else {
			System.out.println("审核版视频状态更新失败");
			str = "ERROR";
		}
		return str;
	}
}
