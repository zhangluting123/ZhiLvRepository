package com.zhilv.recommendUser.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.recommendUser.dao.RecommendUserMapper;

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

} 
