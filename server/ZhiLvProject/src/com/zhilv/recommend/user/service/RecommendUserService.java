package com.zhilv.recommend.user.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.User;
import com.zhilv.recommend.user.dao.RecommendUserMapper;

/**
 * 
 * @ClassName:RecommendUserService
 * @description:TODO
 * @author :张梦如
 * @date:2021年1月29日
 */

@Service
public class RecommendUserService {
	
	@Resource
	private RecommendUserMapper recommendUserMapper;

	/**
	 * 
	 * @description:给用户推荐关注的用户关注的用户
	 * @author :张梦如
	 * @date:2021年2月6日
	 * @param userId
	 * @return
	 */
	public List<User> findRecommendUser(Integer userId){
		return recommendUserMapper.findRecommendUser(userId);
	}
	/**
	 * 
	 * @description:给用户推荐相同年龄段的用户，解决冷启动问题
	 * @author :张梦如
	 * @date:2021年2月6日
	 * @param birth
	 * @return
	 */
	public List<User> recommendUserByAge(Date birth){
		return recommendUserMapper.recommendUserByAge(birth);
	}
} 
