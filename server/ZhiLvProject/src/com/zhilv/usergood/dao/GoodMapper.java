package com.zhilv.usergood.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.UserGood;

/**   
 * @ClassName: GoodMapper   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��30�� ����11:14:42       
 */
public interface GoodMapper {
	
	/**
	 * @Title: findAllGood
	 * @Description: ����IDֵ��ѯ�û����еĵ��޼�¼
	 * @author: ����� 
	 * @date: 2021��1��30�� ����11:21:29
	 */
	public List<UserGood> findAllGood(Integer userId);
	
	/**
	 * @Title: findIfGood
	 * @Description: ��ѯ�Ƿ����
	 * @author: ����� 
	 * @date: 2021��1��30�� ����1:05:34
	 */
	public int findIfGood(@Param("userId")Integer userId, @Param("travelsId")Integer travelsId, @Param("videoId")Integer videoId);
	
	/**
	 * @Title: addGood
	 * @Description: ��ӵ��޼�¼
	 * @author: ����� 
	 * @date: 2021��1��30�� ����11:23:40
	 */
	public int addGood(@Param("userId")Integer userId, @Param("travelsId")Integer travelsId, @Param("videoId")Integer videoId, @Param("time")Date time);
	
	/**
	 * @Title: deleteGood
	 * @Description: ȡ������
	 * @author: ����� 
	 * @date: 2021��1��30�� ����11:24:10
	 */
	public int deleteGood(@Param("userId")Integer userId, @Param("travelsId")Integer travelsId, @Param("videoId")Integer videoId);
	
	/**
	 * @Title: findPraised
	 * @Description: ��ѯ�������
	 * @author: ����� 
	 * @date: 2021��1��30�� ����3:50:13
	 */
	public List<UserGood> findPraised(Integer userId);

}
