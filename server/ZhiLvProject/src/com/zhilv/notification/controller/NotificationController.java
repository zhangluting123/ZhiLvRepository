package com.zhilv.notification.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.zhilv.entity.Notification;
import com.zhilv.notification.service.NotificationService;

/**   
 * @ClassName: NotificationController   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��13�� ����4:44:20       
 */
@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Resource
	private NotificationService notificationService;
	
	@RequestMapping(value="/find", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String findNotificationByUserId(HttpServletRequest request, @RequestParam(value="userId", required=true)String userId) {
		List<Notification> list = this.notificationService.findNotification(userId);
		for(Notification n: list) {
			System.out.println(n);
		}
		String str = "";
		if(list.size() > 0) {
			Gson gson = new Gson();
			str = gson.toJson(list);
			System.out.println("����"+list.size()+"��֪ͨ");
		}else {
			System.out.println("����0��֪ͨ");
		}
		return str;
	}
}
