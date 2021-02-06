package com.zhilv.recommend.user.dao;

import java.util.Date;
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
	
		
	/**
	 * 
	 * @description:���û��Ƽ���ע���û���ע���û�
	 * @author :������
	 * @date:2021��2��6��
	 * @param userId
	 * @return �û��б�
	 */
	public List<User> findRecommendUser(Integer userId);
	
	/**
	 * 
	 * @description:�����û�������Ƽ����ѣ��������������
	 * @author :������
	 * @date:2021��2��6��
	 * @param userId
	 * @return
	 */
	public List<User> recommendUserByAge(Date birth);
	

}
