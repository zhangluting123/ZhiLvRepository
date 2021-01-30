package com.zhilv.usercollection.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.UserCollection;
import com.zhilv.usercollection.dao.CollectionMapper;

/**   
 * @ClassName: CollectionService   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月30日 上午11:32:56       
 */
@Service
public class CollectionService {
	
	@Resource
	private CollectionMapper collectionMapper;
	
	/**
	 * @Title: findAllCollection
	 * @Description: 查询所有收藏
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 上午11:31:15
	 */
	public List<UserCollection> findAllCollection(Integer userId){
		return collectionMapper.findAllCollection(userId);
	}
	
	/**
	 * @Title: findIfCollect
	 * @Description: 查询是否收藏
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 下午1:13:12
	 */
	public int findIfCollect(Integer userId, Integer travelsId, Integer videoId) {
		return collectionMapper.findIfCollect(userId, travelsId, videoId);
	}
	
	/**
	 * @Title: addCollection
	 * @Description: 添加收藏
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 上午11:31:38
	 */
	public int addCollection(Integer userId, Integer travelsId, Integer videoId, Date time) {
		return collectionMapper.addCollection(userId, travelsId, videoId, time);
	}
	
	/**
	 * @Title: deleteCollection
	 * @Description: 取消收藏
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 上午11:32:05
	 */
	public int deleteCollection(Integer userId,Integer travelsId,Integer videoId) {
		return collectionMapper.deleteCollection(userId, travelsId, videoId);
	}

}
