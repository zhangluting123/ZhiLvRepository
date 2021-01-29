package com.zhilv.recommendUser.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.recommendUser.dao.RecommendUserMapper;

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

} 
