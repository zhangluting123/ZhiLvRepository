package com.zhilv.views.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: ViewsMapper   
 * @Description:
 * @author: �����
 * @date: 2021��2��10�� ����3:03:20
 */
public interface ViewsMapper {
	
	/**
	 * @Title: addViews
	 * @Description: ��������¼
	 * @author: �����
	 * @date: 2021��2��10�� ����3:21:30
	 */
	public int addViews(@Param("userId")Integer userId, @Param("time")Date time,@Param("travelsId")Integer travelsId, @Param("videoId")Integer videoId, @Param("sceneId")Integer sceneId );

}
