package com.zhilv.audit.scene.controller;

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

import com.zhilv.audit.scene.service.AuditSceneService;
import com.zhilv.entity.AuditScene;
import com.zhilv.entity.Scene;
import com.zhilv.recommend.scene.service.SceneService;
import com.zhilv.util.DateUtil;
import com.zhilv.util.FinalUtil;
import com.zhilv.util.Page;

/**   
 * @ClassName: AuditSceneController   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年2月8日 上午10:23:39       
 */
@Controller
@RequestMapping("/audit/scene")
public class AuditSceneController {

	@Resource
	private AuditSceneService auditSceneService;
	@Resource
	private SceneService sceneService;
	
	@RequestMapping(value="/list/{pageNum}",method=RequestMethod.GET)
	public String list(@PathVariable(value="pageNum",required=true)int pageNum, Model model) {
		List<AuditScene> list = auditSceneService.findForPage((pageNum-1)*FinalUtil.PAGE_SIZE,FinalUtil.PAGE_SIZE);
		Page<AuditScene> page = new Page<>(pageNum,FinalUtil.PAGE_SIZE);
		page.setList(list);
		page.setTotalCount(auditSceneService.findSceneCount());
		model.addAttribute("scenePage",page);
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="/change", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public String changeMsg(HttpServletRequest request) {
		String str = "";
		AuditScene auditScene = new AuditScene();
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem fi : items) {
				if(fi.isFormField()) {
					String string = fi.getString("utf-8");
					switch (fi.getFieldName()) {
						case "sceneId":
							auditScene.setSceneId(Integer.parseInt(string));
							break;
						case "title":
							auditScene.setTitle(string);
							break;
						case "content":
							auditScene.setContent(string);
							break;
						case "rule":
							auditScene.setRule(string);
							break;
						case "openTime":
							auditScene.setOpenTime(string);
							break;
						case "traffic":
							auditScene.setTraffic(string);
							break;
						case "ticket":
							auditScene.setTicket(string);
							break;
						case "costTime":
							auditScene.setCostTime(string);
						case "phone":
							auditScene.setPhone(string);
							break;
						case "website":
							auditScene.setWebsite(string);
							break;
						case "userId":
							auditScene.setUserId(Integer.parseInt(string));
							break;
						default:
							break;
					}
				}else {
					String realPath = request.getSession().getServletContext().getRealPath("/");
					fi.write(new File(realPath+"scene\\"+fi.getName()));
					auditScene.setPath("scene/"+fi.getName());
				}
			}
			auditScene.setUpdateTime(DateUtil.getCurrentTimes());
			auditScene.setStatus(0);
			int b = auditSceneService.addAuditScene(auditScene);
			if(b > 0) {
				str = "OK";
				System.out.println("添加审核版景点成功");
			}else {
				str = "ERROR";
				System.out.println("添加审核版景点失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String update(@RequestParam("auditId")Integer auditId,@RequestParam("status")Integer status) {
		int i = auditSceneService.updateSceneStatus(auditId, status, DateUtil.getCurrentTimes());
		if(i > 0) {
			System.out.println("审核版景点状态更新成功");
			if(status == 1) { //通过审核则更新发布版景点
				AuditScene auditScene = auditSceneService.findAuditSceneById(auditId);
				Scene scene = new Scene();
				scene.setSceneId(auditScene.getSceneId());
				scene.setPath(auditScene.getPath());
				scene.setTitle(auditScene.getTitle());
				scene.setContent(auditScene.getContent());
				scene.setRule(auditScene.getRule());
				scene.setOpenTime(auditScene.getOpenTime());
				scene.setTraffic(auditScene.getOpenTime());
				scene.setTicket(auditScene.getTicket());
				scene.setCostTime(auditScene.getCostTime());
				scene.setPhone(auditScene.getPhone());
				scene.setWebsite(auditScene.getWebsite());
		
				int j = sceneService.updateScene(scene);
				j += sceneService.addSceneUpdateMsg(auditScene.getUserId(), auditScene.getSceneId(), auditScene.getUpdateTime());
				if(j > 1) {
					System.out.println("发布版景点修改成功");
					return "OK";
				}else {
					System.out.println("发布版景点修改失败");
					return "ERROR";
				}
			}
			return "OK";
		}else {
			System.out.println("审核版话题状态更新失败");
			return "ERROR";
		}
	}
}
