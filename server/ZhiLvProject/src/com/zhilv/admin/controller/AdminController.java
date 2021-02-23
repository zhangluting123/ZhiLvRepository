package com.zhilv.admin.controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhilv.admin.service.AdminService;
import com.zhilv.util.JudgeStrUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	private AdminService adminService;

	@ResponseBody
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(@RequestParam("name")String name,
			@RequestParam("email")String email,
			@RequestParam("password")String passowrd) {
		int i = adminService.addAdmin(email, name, passowrd);
		if(i > 0) {
			return "OK";
		}else {
			return "ERROR";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/confirmEmail",method=RequestMethod.POST)
	public String confirmEmail(@RequestParam("email")String email) {
		if(JudgeStrUtil.isEmail(email)) {
			int i = adminService.findAdminByNameOrEmail(null, email);
			if(i > 0) {
				return "ERROR";
			}else {
				return "OK";
			}
		}else {
			return "ERRORSTYLE";
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/confirmName",method=RequestMethod.POST)
	public String confirmName(@RequestParam("name")String name) {
		int i = adminService.findAdminByNameOrEmail(name, null);
		if(i > 0) {
			return "ERROR";
		}else {
			return "OK";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="text/plain;charset=utf-8")
	public String login(@RequestParam("name")String name,@RequestParam("password")String passowrd) {
		int i = adminService.findAdminByNameAndPwd(name, passowrd);
		if(i > 0) {
			return name;
		}else {
			System.out.println("error");
			return "ERROR";
		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login.jsp";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model, @RequestParam("name")String name,HttpServletRequest request) {
//		System.out.println(name);
		ServletContext context = request.getServletContext();
		context.setAttribute("nickname",name);
		return "forward:/audit/scene/list/1";
	}
}



