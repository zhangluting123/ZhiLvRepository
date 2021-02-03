package com.zhilv.topic.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.zhilv.entity.Topic;
import com.zhilv.topic.service.TopicService;

/**   
 * @ClassName: TopicController   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月19日 下午5:16:36       
 */
@RestController
@RequestMapping("/topic")
public class TopicController {
	
	@Resource
	private TopicService topicService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String list() {
		String string = null;
		List<Topic> list = topicService.findAllTopic();
		if(list.size() > 0) {
			Gson gson = new Gson();
			string = gson.toJson(list);	
		}
		return string;
	}
	
	@RequestMapping(value="/like",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String like(@RequestParam("str")String str) {
		String string= null;
		List<Topic> list = topicService.findTopicByStr(str);
		if(list.size() > 0) {
			Gson gson = new Gson();
			string = gson.toJson(list);
		}
		return string;
	}
	
	@RequestMapping(value="/twiceUsed",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String twiceUsed() {
		String string= null;
		List<Topic> list = topicService.findTwiceTopicUsed();
		if(list.size() > 0) {
			Gson gson = new Gson();
			string = gson.toJson(list);
		}
		return string;
	}
}
