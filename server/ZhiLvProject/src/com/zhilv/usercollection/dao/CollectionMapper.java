package com.zhilv.usercollection.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.UserCollection;

/**   
 * @ClassName: CollectionMapper   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��30�� ����11:20:33       
 */
public interface CollectionMapper {
	
	/**
	 * @Title: findAllCollection
	 * @Description: ��ѯ�����ղ�
	 * @author: ����� 
	 * @date: 2021��1��30�� ����11:31:15
	 */
	public List<UserCollection> findAllCollection(Integer userId);
	
	/**
	 * @Title: findIfGood
	 * @Description: ��ѯ�Ƿ��ղ�
	 * @author: ����� 
	 * @date: 2021��1��30�� ����1:10:54
	 */
	public int findIfCollect(@Param("userId")Integer userId, @Param("travelsId")Integer travelsId, @Param("videoId")Integer videoId);
	
	/**
	 * @Title: addCollection
	 * @Description: ����ղ�
	 * @author: ����� 
	 * @date: 2021��1��30�� ����11:31:38
	 */
	public int addCollection(@Param("userId")Integer userId, @Param("travelsId")Integer travelsId, @Param("videoId")Integer videoId, @Param("time")Date time);
	
	/**
	 * @Title: deleteCollection
	 * @Description: ȡ���ղ�
	 * @author: ����� 
	 * @date: 2021��1��30�� ����11:32:05
	 */
	public int deleteCollection(@Param("userId")Integer userId, @Param("travelsId")Integer travelsId, @Param("videoId")Integer videoId);

}
