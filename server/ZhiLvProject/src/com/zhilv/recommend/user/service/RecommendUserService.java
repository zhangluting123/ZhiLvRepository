package com.zhilv.recommend.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.User;
import com.zhilv.recommend.user.dao.RecommendUserMapper;

/**
 * 
 * @ClassName:RecommendUserService
 * @description:TODO
 * @author :������
 * @date:2021��1��29��
 */

@Service
public class RecommendUserService {
	
	@Resource
	private RecommendUserMapper recommendUserMapper;

	public List<User> findRecommendUser(Integer userId){
		return recommendUserMapper.findRecommendUser(userId);
	}
} 
