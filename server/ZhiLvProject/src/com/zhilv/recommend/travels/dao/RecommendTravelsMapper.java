/**
 * 
 */
package com.zhilv.recommend.travels.dao;

import java.util.List;

import com.zhilv.entity.InterestLabel;

/**
 * @ClassName:RecommendTravelsMapper
 * @description:TODO
 * @author :张梦如
 * @date:2021年2月8日
 */
public interface RecommendTravelsMapper {
	
	/**
	 * 
	 * @description:根据用户ID查找用户兴趣列表
	 * @author :张梦如
	 * @date:2021年2月9日
	 * @param UserId
	 * @return
	 */
	public List<InterestLabel> findUserInterest(Integer UserId);

}
