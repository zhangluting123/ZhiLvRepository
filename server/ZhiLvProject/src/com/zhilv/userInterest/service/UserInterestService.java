/**
 * 
 */
package com.zhilv.userInterest.service;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhilv.entity.MoreDetail;
import com.zhilv.entity.UserInterest;
import com.zhilv.userInterest.dao.UserInterestMapper;

/**
 * @ClassName:UserInterestService
 * @description:TODO
 * @author :张梦如
 * @date:2021年2月16日
 */
@Service
@Transactional(readOnly = false)
public class UserInterestService {
	
	@Resource
	private UserInterestMapper userInterestMapper;
	
	/**
	 * 
	 * @description:添加兴趣
	 * @author :张梦如
	 * @date:2021年2月17日
	 * @param userId
	 * @param labelId
	 * @param weight
	 * @return
	 */
	public int addInterest(Integer userId, Integer labelId,Integer weight) {
		return userInterestMapper.addInterest(userId, labelId, weight);
	}

	
	/**
	 * @description:查询用户兴趣
	 * @author :张梦如
	 * @date:2021年2月17日
	 * @param userId
	 * @return
	 */
	@Transactional(readOnly = true)
	public UserInterest findInterestByUserIdAndLabelId(Integer userId, Integer labelId) {
		return userInterestMapper.findInterestByUserIdAndLabelId(userId, labelId);
	}
	
	
	/**
	 * @description:修改权重
	 * @author :张梦如
	 * @date:2021年2月17日
	 * @param interestId
	 * @param weight
	 * @return
	 */
	public int updateWeightByInterestId(Integer interestId, Integer weight) {
		return userInterestMapper.updateWeightByInterestId(interestId, weight);
	}
	
	/**
	 * 
	 * @description:删除用户兴趣
	 * @author :张梦如
	 * @date:2021年2月17日
	 * @param interestId
	 * @return
	 */
	public int deleteInterestById(Integer interestId) {
		return userInterestMapper.deleteInterestById(interestId);
	}
	
	/**
	 * @description:查询游记或视频详情
	 * @author :张梦如
	 * @date:2021年2月17日
	 * @param travelsId
	 * @param videoId
	 * @return
	 */
	public MoreDetail findMoreDetailByTidOrVid(Integer travelsId,Integer videoId) {
		return userInterestMapper.findMoreDetailByTidOrVid(travelsId, videoId);
	}
	
	/**
	 * @description:查询LabelID
	 * @author :张梦如
	 * @date:2021年2月17日
	 * @param name
	 * @return
	 */
	public int findLabelIdByName(String name) {
		return userInterestMapper.findLabelIdByName(name);
	}
}
