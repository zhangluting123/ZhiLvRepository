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
 * @author :������
 * @date:2021��2��8��
 */

@Service
public class RecommendTravelsService {
	
	@Resource
	private RecommendTravelsMapper recommendTravelsMapper;
	
	/**
	 * 
	 * @description:�����û�ID�����û���Ȥ����
	 * @author :������
	 * @date:2021��2��9��
	 * @param userId
	 * @return
	 */
	public List<InterestLabel> findUserInterest(Integer userId){
		return recommendTravelsMapper.findUserInterest(userId);
	}

}
