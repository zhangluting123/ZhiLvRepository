/**
 * 
 */
package com.zhilv.recommend.travels.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhilv.entity.User;
import com.zhilv.recommend.travels.service.RecommendTravelsService;
import com.zhilv.user.service.UserService;

/**
 * @ClassName:RecommendTravelsController
 * @description:TODO
 * @author :������
 * @date:2021��2��8��
 */

@RestController
@RequestMapping("recommend/travels")
public class RecommendTravelsController {
	
	@Resource
	private RecommendTravelsService recommendTravelsService;
	
	@Resource
	private UserService userService;
	
	/**
	 * 
	 * @description:��ȡ�͵�ǰ�û���ص��û�����
	 * @author :������
	 * @date:2021��2��9��
	 * @param userId
	 * @return
	 */
	//http://localhost:8080/ZhiLvProject/recommend/travels/getSimilarUser?userId=1
	@RequestMapping(value = "/getSimilarUser",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public List<User> getSimilarUser(Integer userId){
		List<User> allUsers=userService.findAllUser();
		allUsers.remove(userService.findUserByUserId(userId));
		List<User> similarUsers = new ArrayList<>();
		for(int i = 0;i < allUsers.size(); i++)
		{
			if(userSimilarity(userId, allUsers.get(i).getUserId())>0.0) {
				similarUsers.add(allUsers.get(i));
			}
		}
		
		return similarUsers;
		
	}
	
	/**
	 * 
	 * @description:����Jaccard��ʽ�����û���Ȥ���ƶ�
	 * @author :������
	 * @date:2021��2��9��
	 * @param userId1
	 * @param userId2
	 * @return �û���Ȥ���ƶȣ�intersection / union��
	 */
	
	//http://localhost:8080/ZhiLvProject/recommend/travels/userSimilarity?userId1=1&userId2=2
	@RequestMapping(value = "/userSimilarity",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public double userSimilarity(Integer userId1,Integer userId2) {
		List<String> userInterest1=recommendTravelsService.findUserInterest(userId1);
		List<String> userInterest2=recommendTravelsService.findUserInterest(userId2);
		
		List<String> union = new ArrayList<>();
		List<String> intersection = new ArrayList<>();
		//��userInterest1�е�Ԫ���ȷ���union
		for(int i = 0;i<userInterest1.size();i++) {
			union.add(userInterest1.get(i));
		}
		//��userInterest2��union���бȽ�
		for(int i = 0;i < userInterest2.size(); i++) {
			if(union.contains(userInterest2.get(i))) {
				//��������д��ڣ����뵽������
				intersection.add(userInterest2.get(i));
			}else {
				//��������в����ڣ����뵽������
				union.add(userInterest2.get(i));
			}
		}
		
		// ������Ȥ���ƶ� intersection/union
		double similarity = (double) intersection.size()/union.size();
		
		return similarity;
		
	}
	

}
