package com.zhilv.usercollection.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.UserCollection;

/**   
 * @ClassName: CollectionMapper   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月30日 上午11:20:33       
 */
public interface CollectionMapper {
	
	/**
	 * @Title: findAllCollection
	 * @Description: 查询所有收藏
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 上午11:31:15
	 */
	public List<UserCollection> findAllCollection(Integer userId);
	
	/**
	 * @Title: findIfGood
	 * @Description: 查询是否收藏
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 下午1:10:54
	 */
	public int findIfCollect(@Param("userId")Integer userId, @Param("travelsId")Integer travelsId, @Param("videoId")Integer videoId);
	
	/**
	 * @Title: addCollection
	 * @Description: 添加收藏
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 上午11:31:38
	 */
	public int addCollection(@Param("userId")Integer userId, @Param("travelsId")Integer travelsId, @Param("videoId")Integer videoId, @Param("time")Date time);
	
	/**
	 * @Title: deleteCollection
	 * @Description: 取消收藏
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 上午11:32:05
	 */
	public int deleteCollection(@Param("userId")Integer userId, @Param("travelsId")Integer travelsId, @Param("videoId")Integer videoId);

}
