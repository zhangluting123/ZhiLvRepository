package com.zhilv.notification.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.Notification;



/**   
 * @ClassName: NotificationDao   
 * @Description:��Ϣ֪ͨӳ��ӿ�
 * @author: �����
 * @date: 2021��1��13�� ����4:48:03       
 */
public interface NotificationMapper {
	/**
	 * @Title: findNotification
	 * @Description: ����ĳһ����Ϣ
	 * @author: ����� 
	 * @date: 2021��1��13�� ����4:56:27
	 */
	public List<Notification> findNotification(@Param("userId")String userId);
}
