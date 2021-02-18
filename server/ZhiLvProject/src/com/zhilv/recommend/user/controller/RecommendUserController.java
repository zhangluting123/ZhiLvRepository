package com.zhilv.recommend.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
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

	/**
	 * 
	 * @description:生成最后的用户推荐列表
	 * @author :张梦如
	 * @date:2021年2月18日
	 * @param userId
	 * @return
	 */
	//http://localhost:8080/ZhiLvProject/recommend/user/getRecommendList?userId=6
	@RequestMapping(value="/getRecommendList",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public String getRecommendList(@RequestParam("userId")Integer userId) {
		List<User> recommendList = new ArrayList<User>();
		List<User> recommendList1 = list(userId);
		List<User> recommendList2 = recommendByCommonFolled(userId);
		List<User> recommendList3 = recommendUserByAge(userId);
		recommendList.addAll(recommendList1);
		recommendList.addAll(recommendList2);
		recommendList.addAll(recommendList3);
		
		if(recommendList.size()>0) {
			Gson gson=new Gson();
			String str = gson.toJson(recommendList);
			return str;
		}else {
			return null;
		}
		
	}
	
	/**
	 * 
	 * @description:给用户推荐关注的用户关注的用户
	 * @author :张梦如
	 * @date:2021年2月5日
	 * @param userId
	 * @return
	 */
	
	
	public List<User> list(Integer userId) {
		List<User> list = recommendUserService.findRecommendUser(userId);//4 5
		list = removeRepeat(list, userId);
//		List<User> attenList = userService.findFollowed(userId);//4 6
//	
//		for(int i = 0; i < list.size(); ++i) {
//			System.out.println(i+"======");
//			if(list.get(i).getUserId() == userId) {
//				System.out.println(i+"-----"+list.get(i).getUserId());
//				list.remove(i);
//				i--;
//			}else {
//				for(int j = 0; j < attenList.size(); ++j) {
//					if(list.get(i).getUserId()== attenList.get(j).getUserId()) {
//						list.remove(i);
//						i--;
//						break;
//					}
//				}
//			}
//			
//		}

//		if(list.size() > 0) {
//			Gson gson = new Gson();
////			Gson gson2 = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//			String str = gson.toJson(list);
//			return str;
//		}else {
//			return null;
//		}
		
		return list;
	}
	/**
	 *
	 * @description:根据共同关注，生成用户推荐列表
	 * @author :张梦如
	 * @date:2021年2月5日
	 * @param userId
	 * @return
	 */
	
	public List<User> recommendByCommonFolled(Integer userId) {
		List<User> allUsers=userService.findAllUser();
		List<User> followedList1=userService.findFollowed(userId);
		double commonFollowed;
		for(int i = 0;i<allUsers.size();i++) {
			List<User> followedList2=userService.findFollowed(allUsers.get(i).getUserId());
			commonFollowed=commonFollowedNum(followedList1, followedList2);
			if(commonFollowed==0.0) {
				allUsers.remove(i);
				
			}
		}
		allUsers = removeRepeat(allUsers, userId);
		
		return allUsers;
//		if(allUsers.size()>0) {
//			Gson gson=new Gson();
//			String str = gson.toJson(allUsers);
//			return str;
//		}else {
//			return null;
//		}
		
		
	}
	
	/**
	 * @description:根据用户年龄推荐好友，解决系统冷启动问题
	 * @author :张梦如
	 * @date:2021年2月6日
	 * @param userId
	 * @return
	 */
	
	public List<User> recommendUserByAge(Integer userId) {
		User presentUser=userService.findUserByUserId(userId);
		List<User> recommendList = recommendUserService.recommendUserByAge(presentUser.getBirth());
		recommendList=removeRepeat(recommendList, userId);
		
		return recommendList;
//		if(recommendList.size()>0) {
//			Gson gson = new Gson();
//			String str = gson.toJson(recommendList);
//			return str;
//		}else {
//			return null;
//		}
	}
	
	/**
	 * 
	 * @description:计算两个用户之间是共同关注的用户所占比例
	 * @author :张梦如
	 * @date:2021年2月5日
	 * @param list1
	 * @param list2
	 * @return 返回比例值
	 */

	public double commonFollowedNum(List<User> list1,List<User> list2) {
		int common=0;
		double rate;
		for(int i = 0;i<list1.size();i++) {
			for(int j = 0;j<list2.size();j++) {
				if(list1.get(i).getUserId()==list2.get(j).getUserId()) {
					common+=1;
				}
			}
		}
		rate=common/(list1.size()+list2.size()-common);
		return rate;
	}
	
	/**
	 * 
	 * @description:从生成的推荐列表中去除已经关注的用户及用户本身
	 * @author :张梦如
	 * @date:2021年2月5日
	 * @param recommendUser
	 * @param userId
	 * @return
	 */

	public List<User> removeRepeat(List<User> recommendUser,Integer userId){
		
		List<User> attenList = userService.findFollowed(userId);//4 6
		List<User> list=recommendUser;
		for(int i = 0; i < list.size(); ++i) {
//			System.out.println(i+"======");
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
		return list;
	}
	
	
	
}
