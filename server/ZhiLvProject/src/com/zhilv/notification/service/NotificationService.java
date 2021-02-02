package com.zhilv.notification.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.Notification;
import com.zhilv.notification.dao.NotificationMapper;



/**   
 * @ClassName: NotificationService   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��13�� ����4:45:05       
 */
@Service
public class NotificationService {

	@Resource
	private NotificationMapper notificationMapper;
	
	public List<Notification> findNotification(String userId){
		return notificationMapper.findNotification(userId);
	}
	
	/**
	 * @Title: addNotification
	 * @Description: �����Ϣ
	 * @author: ����� 
	 * @date: 2021��2��2�� ����2:49:38
	 */
	public int addNotification(Notification notification){
		return notificationMapper.addNotification(notification);
	}
}
