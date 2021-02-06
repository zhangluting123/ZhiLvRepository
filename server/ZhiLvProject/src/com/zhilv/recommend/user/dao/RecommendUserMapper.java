package com.zhilv.recommend.user.dao;

import java.util.List;

import com.zhilv.entity.User;

/**
 * 
 * @ClassName:RecommendUserMapper
 * @description:TODO
 * @author 张梦如
 * @date:2021年1月29日
 */


public interface RecommendUserMapper {
	
	
	//	给用户推荐关注的用户关注的用户
	public List<User> findRecommendUser(Integer userId);
	

}
