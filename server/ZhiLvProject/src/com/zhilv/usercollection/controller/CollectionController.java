package com.zhilv.usercollection.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhilv.usercollection.service.CollectionService;
import com.zhilv.util.DateUtil;

/**   
 * @ClassName: CollectionController   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��30�� ����11:33:05       
 */
@RestController
@RequestMapping("/collection")
public class CollectionController {
	
	@Resource
	private CollectionService collectionService;
	
	@RequestMapping(value="/ifCollect",method=RequestMethod.GET)
	public String IfCollect(@RequestParam(value="userId",required=true)Integer userId,
			@RequestParam(value="videoId",required=false)Integer videoId,
			@RequestParam(value="travelsId",required=false)Integer travelsId) {
		int i = collectionService.findIfCollect(userId, travelsId, videoId);
		if(i > 0) {
			return "TRUE";
		}else {
			return "FALSE";
		}
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@RequestParam(value="userId",required=true)Integer userId,
			@RequestParam(value="videoId",required=false)Integer videoId,
			@RequestParam(value="travelsId",required=false)Integer travelsId) {
		int i = collectionService.addCollection(userId, travelsId, videoId, DateUtil.getCurrentTimes());
		if(i > 0) {
			return "OK";
		}else {
			return "ERROR";
		}
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@RequestParam(value="userId",required=true)Integer userId,
			@RequestParam(value="videoId",required=false)Integer videoId,
			@RequestParam(value="travelsId",required=false)Integer travelsId) {
		int i = collectionService.deleteCollection(userId, travelsId, videoId);
		if(i > 0) {
			return "OK";
		}else {
			return "ERROR";
		}
	}

}
