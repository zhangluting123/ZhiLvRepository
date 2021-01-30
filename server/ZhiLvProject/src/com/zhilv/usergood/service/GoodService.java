package com.zhilv.usergood.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.UserGood;
import com.zhilv.usergood.dao.GoodMapper;

/**   
 * @ClassName: GoodService   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月30日 上午11:15:18       
 */
@Service
public class GoodService {
	
	@Resource
	private GoodMapper goodMapper;
	
	/**
	 * @Title: findAllGood
	 * @Description: 根据ID值查询用户所有的点赞记录
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 上午11:21:29
	 */
	public List<UserGood> findAllGood(Integer userId){
		return goodMapper.findAllGood(userId);
	}
	
	/**
	 * @Title: findIfGood
	 * @Description: 查询是否点赞
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 下午1:08:07
	 */
	public int findIfGood(Integer userId,Integer travelsId,Integer videoId) {
		return goodMapper.findIfGood(userId, travelsId, videoId);
	}
	
	/**
	 * @Title: addGood
	 * @Description: 添加点赞记录
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 上午11:23:40
	 */
	public int addGood(Integer userId, Integer travelsId, Integer videoId,Date time) {
		return goodMapper.addGood(userId, travelsId, videoId, time);
	}
	
	/**
	 * @Title: deleteGood
	 * @Description: 取消点赞
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 上午11:24:10
	 */
	public int deleteGood(Integer userId,Integer travelsId,Integer videoId) {
		return goodMapper.deleteGood(userId, travelsId, videoId);
	}
	
	/**
	 * @Title: findPraised
	 * @Description: 查询被赞情况
	 * @author: 张璐婷 
	 * @date: 2021年1月30日 下午3:50:13
	 */
	public List<UserGood> findPraised(Integer userId){
		return goodMapper.findPraised(userId);
	}

}
