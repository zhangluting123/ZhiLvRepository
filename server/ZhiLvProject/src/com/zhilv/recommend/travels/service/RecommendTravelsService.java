/**
 * 
 */
package com.zhilv.recommend.travels.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.InterestLabel;
import com.zhilv.recommend.travels.dao.RecommendTravelsMapper;

/**
 * @ClassName:RecommendTravelsService
 * @description:TODO
 * @author :张梦如
 * @date:2021年2月8日
 */

@Service
public class RecommendTravelsService {
	
	@Resource
	private RecommendTravelsMapper recommendTravelsMapper;
	
	/**
	 * 
	 * @description:根据用户ID查找用户兴趣集合
	 * @author :张梦如
	 * @date:2021年2月9日
	 * @param userId
	 * @return
	 */
	public List<InterestLabel> findUserInterest(Integer userId){
		return recommendTravelsMapper.findUserInterest(userId);
	}

}
