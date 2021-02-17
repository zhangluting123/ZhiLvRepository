/**
 * 
 */
package com.zhilv.userInterest.dao;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.InterestLabel;
import com.zhilv.entity.MoreDetail;
import com.zhilv.entity.UserInterest;

/**
 * @ClassName:UserInterestMapper
 * @description:TODO
 * @author :张梦如
 * @date:2021年2月16日
 */
public interface UserInterestMapper {
	
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
	public int addInterest(@Param("userId")Integer userId, @Param("labelId")Integer labelId,@Param("weight")Integer weight);
	
	/**
	 * @description:查询用户兴趣
	 * @author :张梦如
	 * @date:2021年2月17日
	 * @param userId
	 * @return
	 */
	public UserInterest findInterestByUserIdAndLabelId(@Param("userId")Integer userId, @Param("labelId")Integer labelId);
	
	
	/**
	 * @description:修改权重
	 * @author :张梦如
	 * @date:2021年2月17日
	 * @param interestId
	 * @param weight
	 * @return
	 */
	public int updateWeightByInterestId(@Param("interestId")Integer interestId, @Param("weight")Integer weight);
	
	/**
	 * 
	 * @description:删除用户兴趣
	 * @author :张梦如
	 * @date:2021年2月17日
	 * @param interestId
	 * @return
	 */
	public int deleteInterestById(Integer interestId);
	
	/**
	 * @description:查询游记或视频详情
	 * @author :张梦如
	 * @date:2021年2月17日
	 * @param travelsId
	 * @param videoId
	 * @return
	 */
	public MoreDetail findMoreDetailByTidOrVid(@Param("travelsId")Integer travelsId,@Param("videoId")Integer videoId);
	
	/**
	 * @description:查询LabelID
	 * @author :张梦如
	 * @date:2021年2月17日
	 * @param name
	 * @return
	 */
	public int findLabelIdByName(String name);

}






