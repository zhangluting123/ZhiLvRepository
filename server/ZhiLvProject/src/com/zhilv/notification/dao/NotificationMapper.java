package com.zhilv.notification.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.Notification;



/**   
 * @ClassName: NotificationDao   
 * @Description:消息通知映射接口
 * @author: 张璐婷
 * @date: 2021年1月13日 下午4:48:03       
 */
public interface NotificationMapper {
	/**
	 * @Title: findNotification
	 * @Description: 查找某一条消息
	 * @author: 张璐婷 
	 * @date: 2021年1月13日 下午4:56:27
	 */
	public List<Notification> findNotification(@Param("userId")String userId);
}
