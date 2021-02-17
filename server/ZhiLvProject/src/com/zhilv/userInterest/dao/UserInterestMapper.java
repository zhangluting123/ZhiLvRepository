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
 * @author :������
 * @date:2021��2��16��
 */
public interface UserInterestMapper {
	
	/**
	 * 
	 * @description:�����Ȥ
	 * @author :������
	 * @date:2021��2��17��
	 * @param userId
	 * @param labelId
	 * @param weight
	 * @return
	 */
	public int addInterest(@Param("userId")Integer userId, @Param("labelId")Integer labelId,@Param("weight")Integer weight);
	
	/**
	 * @description:��ѯ�û���Ȥ
	 * @author :������
	 * @date:2021��2��17��
	 * @param userId
	 * @return
	 */
	public UserInterest findInterestByUserIdAndLabelId(@Param("userId")Integer userId, @Param("labelId")Integer labelId);
	
	
	/**
	 * @description:�޸�Ȩ��
	 * @author :������
	 * @date:2021��2��17��
	 * @param interestId
	 * @param weight
	 * @return
	 */
	public int updateWeightByInterestId(@Param("interestId")Integer interestId, @Param("weight")Integer weight);
	
	/**
	 * 
	 * @description:ɾ���û���Ȥ
	 * @author :������
	 * @date:2021��2��17��
	 * @param interestId
	 * @return
	 */
	public int deleteInterestById(Integer interestId);
	
	/**
	 * @description:��ѯ�μǻ���Ƶ����
	 * @author :������
	 * @date:2021��2��17��
	 * @param travelsId
	 * @param videoId
	 * @return
	 */
	public MoreDetail findMoreDetailByTidOrVid(@Param("travelsId")Integer travelsId,@Param("videoId")Integer videoId);
	
	/**
	 * @description:��ѯLabelID
	 * @author :������
	 * @date:2021��2��17��
	 * @param name
	 * @return
	 */
	public int findLabelIdByName(String name);

}






