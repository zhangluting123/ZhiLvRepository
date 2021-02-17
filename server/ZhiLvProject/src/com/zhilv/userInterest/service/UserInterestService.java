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
 * @author :������
 * @date:2021��2��16��
 */
@Service
@Transactional(readOnly = false)
public class UserInterestService {
	
	@Resource
	private UserInterestMapper userInterestMapper;
	
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
	public int addInterest(Integer userId, Integer labelId,Integer weight) {
		return userInterestMapper.addInterest(userId, labelId, weight);
	}

	
	/**
	 * @description:��ѯ�û���Ȥ
	 * @author :������
	 * @date:2021��2��17��
	 * @param userId
	 * @return
	 */
	@Transactional(readOnly = true)
	public UserInterest findInterestByUserIdAndLabelId(Integer userId, Integer labelId) {
		return userInterestMapper.findInterestByUserIdAndLabelId(userId, labelId);
	}
	
	
	/**
	 * @description:�޸�Ȩ��
	 * @author :������
	 * @date:2021��2��17��
	 * @param interestId
	 * @param weight
	 * @return
	 */
	public int updateWeightByInterestId(Integer interestId, Integer weight) {
		return userInterestMapper.updateWeightByInterestId(interestId, weight);
	}
	
	/**
	 * 
	 * @description:ɾ���û���Ȥ
	 * @author :������
	 * @date:2021��2��17��
	 * @param interestId
	 * @return
	 */
	public int deleteInterestById(Integer interestId) {
		return userInterestMapper.deleteInterestById(interestId);
	}
	
	/**
	 * @description:��ѯ�μǻ���Ƶ����
	 * @author :������
	 * @date:2021��2��17��
	 * @param travelsId
	 * @param videoId
	 * @return
	 */
	public MoreDetail findMoreDetailByTidOrVid(Integer travelsId,Integer videoId) {
		return userInterestMapper.findMoreDetailByTidOrVid(travelsId, videoId);
	}
	
	/**
	 * @description:��ѯLabelID
	 * @author :������
	 * @date:2021��2��17��
	 * @param name
	 * @return
	 */
	public int findLabelIdByName(String name) {
		return userInterestMapper.findLabelIdByName(name);
	}
}
