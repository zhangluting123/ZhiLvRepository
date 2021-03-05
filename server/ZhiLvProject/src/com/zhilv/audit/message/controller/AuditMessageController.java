package com.zhilv.audit.message.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhilv.audit.scene.service.AuditSceneService;
import com.zhilv.audit.topic.service.AuditTopicService;
import com.zhilv.audit.travels.service.AuditTravelsService;
import com.zhilv.audit.video.service.AuditVideoService;
import com.zhilv.entity.AuditMessage;
import com.zhilv.util.SortUtil;

/**
 * 
 * @ClassName: AuditMessageController   
 * @Description:
 * @author: 张璐婷
 * @date: 2021年3月4日 下午9:52:14
 */
@RestController
@RequestMapping("audit/message")
public class AuditMessageController {
	
	@Resource
	private AuditSceneService auditSceneService;
	@Resource
	private AuditTopicService auditTopicService;
	@Resource
	private AuditTravelsService auditTravelsService;
	@Resource
	private AuditVideoService auditVideoService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String list(@RequestParam("userId")Integer userId) {
		List<AuditMessage> list = new ArrayList<AuditMessage>();
		List<AuditMessage> partList = new ArrayList<>();
		list = auditSceneService.findSceneByUserId(userId);//1游记；2视频；3话题；4景点
		for(AuditMessage message: list) {
			message.setFlag(4);
		}
		partList = auditTopicService.findTopicByUserId(userId);
		for(AuditMessage message: partList) {
			message.setFlag(3);
		}
		list.addAll(partList);
		partList = auditTravelsService.findTravelsByUserId(userId);
		for(AuditMessage message: partList) {
			message.setFlag(1);
		}
		list.addAll(partList);
		partList = auditVideoService.findVideoByUserId(userId);
		for(AuditMessage message: partList) {
			message.setFlag(2);
		}
		list.addAll(partList);
		
		SortUtil.sortList(list, "lastTime", "DESC");
		if(list.size() > 0) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String str = gson.toJson(list);
			return str;
		}else {
			return null;
		}
	}
	
	
	
	
	
}




