package com.zhilv.usergood.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhilv.entity.UserGood;
import com.zhilv.usergood.service.GoodService;
import com.zhilv.util.DateUtil;

/**   
 * @ClassName: GoodController   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月30日 上午11:14:31       
 */
@RestController
@RequestMapping("/good")
public class GoodController {
	
	@Resource
	private GoodService goodService;
	
	@RequestMapping(value="/ifGood",method=RequestMethod.GET)
	public String IfGood(@RequestParam(value="userId",required=true)Integer userId,
			@RequestParam(value="videoId",required=false)Integer videoId,
			@RequestParam(value="travelsId",required=false)Integer travelsId) {
		int i = goodService.findIfGood(userId, travelsId, videoId);
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
		int i = goodService.addGood(userId, travelsId, videoId, DateUtil.getCurrentTimes());
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
		int i = goodService.deleteGood(userId, travelsId, videoId);
		if(i > 0) {
			return "OK";
		}else {
			return "ERROR";
		}
	}
	
	@RequestMapping(value="/praised",method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String praised(@RequestParam(value="userId",required=true)Integer userId){
		List<UserGood> list = goodService.findPraised(userId);
		if(list.size() > 0) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String str = gson.toJson(list);
			return str;
		}else {
			return null;
		}
	}
}
