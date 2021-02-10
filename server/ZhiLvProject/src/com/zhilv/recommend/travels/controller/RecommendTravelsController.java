/**
 * 
 */
package com.zhilv.recommend.travels.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.zhilv.entity.InterestLabel;
import com.zhilv.entity.Travels;
import com.zhilv.entity.User;
import com.zhilv.recommend.travels.service.RecommendTravelsService;
import com.zhilv.travels.service.TravelsService;
import com.zhilv.user.service.UserService;

/**
 * @ClassName:RecommendTravelsController
 * @description:TODO
 * @author :张梦如
 * @date:2021年2月8日
 */

@RestController
@RequestMapping("recommend/travels")
public class RecommendTravelsController {
	
	@Resource
	private RecommendTravelsService recommendTravelsService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private TravelsService travelsService;
	
	/**
	 * 
	 * @description:TODO
	 * @author :张梦如
	 * @date:2021年2月10日
	 * @param userId
	 * @return
	 */
	//http://localhost:8080/ZhiLvProject/recommend/travels/test?userId=1
	@RequestMapping(value = "/test",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public String test(@RequestParam("userId")Integer userId) {
		
//		List<User> allUsers= userService.findAllUser();
		List<Double> similarity = new ArrayList<Double>();
		List<InterestLabel> interestLabels = recommendTravelsService.findUserInterest(userId);
		List<InterestLabel> interestLabels2=recommendTravelsService.findUserInterest(2);
		double similar= userSimilarity(interestLabels, interestLabels2);
		similarity.add(similar);
//		return similarity;
		if(similarity.size()>0) {
			Gson gson = new Gson();
			String str = gson.toJson(similarity);
			return str;
		}else {
			return null;
		}
		
	}

	
	/**
	 * 
	 * @description:查询相关用户发布的游记
	 * @author :张梦如
	 * @date:2021年2月9日
	 * @param userId
	 * @return
	 */
	//http://localhost:8080/ZhiLvProject/recommend/travels/similarityUserPublish?userId=1
	@RequestMapping(value = "/similarityUserPublish",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public String similarityUserPublish(@RequestParam("UserId")Integer userId){
		
		List<User> similarityUsers = getSimilarUser(userId);
		List<Travels> publishTravels = new ArrayList<>();
		List<Travels> travels;
		for(int i = 0;i<similarityUsers.size();i++) {
			travels = travelsService.findTravelsByUserId(similarityUsers.get(i).getUserId());
			for(int j = 0;j<travels.size();j++) {
				publishTravels.add(travels.get(i));
			}
		}
		
		if(publishTravels.size()>0) {
			Gson gson = new Gson();
			String str = gson.toJson(publishTravels);
			return str;
		}else {
			return null;
		}
		
		
	}
	
	/**
	 * 
	 * @description:获取和当前用户相关的用户集合
	 * @author :张梦如
	 * @date:2021年2月9日
	 * @param userId
	 * @return
	 */
	//http://localhost:8080/ZhiLvProject/recommend/travels/getSimilarUser?userId=1
	@RequestMapping(value = "/getSimilarUser",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public List<User> getSimilarUser(@RequestParam("userId")Integer userId){
		List<User> allUsers=userService.findAllUser();
		allUsers.remove(userService.findUserByUserId(userId));
		List<User> similarUsers = new ArrayList<>();
		List<InterestLabel> userInterest1 = recommendTravelsService.findUserInterest(userId);
		for(int i = 0;i < allUsers.size(); i++)
		{
			List<InterestLabel> userInterest2=recommendTravelsService.findUserInterest(allUsers.get(i).getUserId());
			
			if(userSimilarity(userInterest1, userInterest2)>0.0) {
				similarUsers.add(allUsers.get(i));
			}
		}
		
		return similarUsers;
	}
	
	/**
	 * 
	 * @description:利用Jaccard公式计算用户兴趣相似度
	 * @author :张梦如
	 * @date:2021年2月9日
	 * @param userId1
	 * @param userId2
	 * @return 用户兴趣相似度（intersection / union）
	 */
	
	//http://localhost:8080/ZhiLvProject/recommend/travels/userSimilarity?userId1=1&userId2=2
	@RequestMapping(value = "/userSimilarity",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public double userSimilarity(@RequestParam("userInterest1")List<InterestLabel> userInterest1,@RequestParam("userInterest2")List<InterestLabel> userInterest2) {
		
		System.out.println(userInterest1);
		System.out.println(userInterest2);
		List<String> union = new ArrayList<>();
		List<String> intersection = new ArrayList<>();
		//将userInterest1中的元素先放入union
		for(int i = 0;i<userInterest1.size();i++) {
			union.add(userInterest1.get(i).getLabelName());
		}
		//将userInterest2与union进行比较
		for(int i = 0;i < userInterest2.size(); i++) {
			if(union.contains(userInterest2.get(i).getLabelName())) {
				//如果并集中存在，加入到交集中
				intersection.add(userInterest2.get(i).getLabelName());
			}else {
				//如果并集中不存在，加入到并集中
				union.add(userInterest2.get(i).getLabelName());
			}
		}
		System.out.println(intersection);
		System.out.println(union);
		
		// 计算兴趣相似度 intersection/union
		if(union.size()!=0) {
			double similarity = (double) intersection.size()/union.size();
			return similarity;
		}else {
			return 0.0;
		}
		
	}
	

}
