package com.zhilv.notification.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.Notification;
import com.zhilv.notification.dao.NotificationMapper;



/**   
 * @ClassName: NotificationService   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月13日 下午4:45:05       
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
	 * @Description: 添加消息
	 * @author: 张璐婷 
	 * @date: 2021年2月2日 下午2:49:38
	 */
	public int addNotification(Notification notification){
		return notificationMapper.addNotification(notification);
	}
}
