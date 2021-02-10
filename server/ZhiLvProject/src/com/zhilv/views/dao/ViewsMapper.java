package com.zhilv.views.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: ViewsMapper   
 * @Description:
 * @author: 张璐婷
 * @date: 2021年2月10日 下午3:03:20
 */
public interface ViewsMapper {
	
	/**
	 * @Title: addViews
	 * @Description: 添加浏览记录
	 * @author: 张璐婷
	 * @date: 2021年2月10日 下午3:21:30
	 */
	public int addViews(@Param("userId")Integer userId, @Param("time")Date time,@Param("travelsId")Integer travelsId, @Param("videoId")Integer videoId, @Param("sceneId")Integer sceneId );

}
