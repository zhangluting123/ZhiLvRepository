package com.zhilv.notification.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhilv.entity.Notification;
import com.zhilv.entity.User;
import com.zhilv.notification.service.NotificationService;
import com.zhilv.user.service.UserService;
import com.zhilv.util.DateUtil;

/**   
 * @ClassName: NotificationController   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��13�� ����4:44:20       
 */
@Controller
@RequestMapping("/notification")
public class NotificationController {

	@Resource
	private NotificationService notificationService;
	@Resource
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String findNotificationByUserId(HttpServletRequest request, @RequestParam(value="userId", required=true)String userId) {
		List<Notification> list = this.notificationService.findNotification(userId);
		for(Notification n: list) {
			System.out.println(n);
		}
		String str = "";
		if(list.size() > 0) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			str = gson.toJson(list);
			System.out.println("����"+list.size()+"��֪ͨ");
		}else {
			System.out.println("����0��֪ͨ");
		}
		return str;
	}
	
	@RequestMapping(value="/userlist", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String queryUser(Model model,HttpServletRequest request) {
		List<User> list = userService.findAllUser();
		model.addAttribute("userList", list);
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(HttpServletRequest request,
			@RequestParam(value="title")String title,
			@RequestParam(value="content")String content,
			@RequestParam(value="userId",required=false)Integer userId) {
		Notification notification = new Notification();
		notification.setTitle(title);
		notification.setContent(content);
		notification.setTime(DateUtil.getCurrentTimes());
		if(null != userId && userId != -1) {
			notification.setUserId(userId);
		}
		int i = notificationService.addNotification(notification);
		if(i > 0) {
			System.out.println("֪ͨ��ӳɹ�");
			return "OK";
		}else {
			System.out.println("֪ͨ���ʧ��");
			return "ERROR";
		}
	}
	
}
