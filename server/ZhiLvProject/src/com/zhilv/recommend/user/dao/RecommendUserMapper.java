package com.zhilv.recommend.user.dao;

import java.util.List;

import com.zhilv.entity.User;

/**
 * 
 * @ClassName:RecommendUserMapper
 * @description:TODO
 * @author ������
 * @date:2021��1��29��
 */


public interface RecommendUserMapper {
	
	
	//	���û��Ƽ���ע���û���ע���û�
	public List<User> findRecommendUser(Integer userId);
	

}
