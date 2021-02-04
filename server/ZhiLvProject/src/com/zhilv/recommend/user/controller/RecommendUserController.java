package com.zhilv.recommend.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhilv.entity.User;
import com.zhilv.recommend.user.service.RecommendUserService;
import com.zhilv.user.service.UserService;

/**
 * @ClassName:RecommendUserController
 * @description:TODO
 * @author 张梦如
 * @date:2021年1月29日
 */
@RestController
@RequestMapping("/recommend/user")
public class RecommendUserController {
	
	@Resource
	private RecommendUserService recommendUserService;
	
	@Resource
	private UserService userService;

	
	//http://localhost:8080/ZhiLvProject/recommend/user/list?userId=6
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public String list(@RequestParam("userId")Integer userId) {
		List<User> list = recommendUserService.findRecommendUser(userId);//4 5
		List<User> attenList = userService.findFollowed(userId);//4 6
	
		for(int i = 0; i < list.size(); ++i) {
			System.out.println(i+"======");
			if(list.get(i).getUserId() == userId) {
				System.out.println(i+"-----"+list.get(i).getUserId());
				list.remove(i);
				i--;
			}else {
				for(int j = 0; j < attenList.size(); ++j) {
					if(list.get(i).getUserId()== attenList.get(j).getUserId()) {
						list.remove(i);
						i--;
						break;
					}
				}
			}
			
		}

		if(list.size() > 0) {
			Gson gson = new Gson();
//			Gson gson2 = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String str = gson.toJson(list);
			return str;
		}else {
			return null;
		}
	}
	
}
