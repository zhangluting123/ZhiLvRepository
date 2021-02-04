package com.zhilv.usergood.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.UserGood;

/**   
 * @ClassName: GoodMapper   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月30日 上午11:14:42       
 */
public interface GoodMapper {
	
	/**
	 * @Title: findAllGood
	 * @Description: 根据ID值查询用户所有的点赞记录
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 上午11:21:29
	 */
	public List<UserGood> findAllGood(Integer userId);
	
	/**
	 * @Title: findIfGood
	 * @Description: 查询是否点赞
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 下午1:05:34
	 */
	public int findIfGood(@Param("userId")Integer userId, @Param("travelsId")Integer travelsId, @Param("videoId")Integer videoId);
	
	/**
	 * @Title: addGood
	 * @Description: 添加点赞记录
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 上午11:23:40
	 */
	public int addGood(@Param("userId")Integer userId, @Param("travelsId")Integer travelsId, @Param("videoId")Integer videoId, @Param("time")Date time);
	
	/**
	 * @Title: deleteGood
	 * @Description: 取消点赞
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 上午11:24:10
	 */
	public int deleteGood(@Param("userId")Integer userId, @Param("travelsId")Integer travelsId, @Param("videoId")Integer videoId);
	
	/**
	 * @Title: findPraised
	 * @Description: 查询被赞情况
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 下午3:50:13
	 */
	public List<UserGood> findPraised(Integer userId);

}
