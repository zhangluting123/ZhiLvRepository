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
 * @author: 张璐婷
 * @date: 2021年1月13日 下午4:44:20       
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
			System.out.println("共有"+list.size()+"条通知");
		}else {
			System.out.println("共有0条通知");
		}
		return str;
	}
}
