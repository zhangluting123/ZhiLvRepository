package com.zhilv.recommend.user.dao;

import java.util.Date;
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
	
		
	/**
	 * 
	 * @description:给用户推荐关注的用户关注的用户
	 * @author :张梦如
	 * @date:2021年2月6日
	 * @param userId
	 * @return 用户列表
	 */
	public List<User> findRecommendUser(Integer userId);
	
	/**
	 * 
	 * @description:根据用户年龄差推荐好友，解决冷启动问题
	 * @author :张梦如
	 * @date:2021年2月6日
	 * @param userId
	 * @return
	 */
	public List<User> recommendUserByAge(Date birth);
	

}
