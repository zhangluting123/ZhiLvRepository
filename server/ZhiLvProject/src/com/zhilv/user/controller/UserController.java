package com.zhilv.user.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.zhilv.entity.Attention;
import com.zhilv.entity.User;
import com.zhilv.user.service.UserService;
import com.zhilv.util.DateUtil;

/**   
 * @ClassName: UserController   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月17日 下午3:37:04       
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String login(@RequestParam(value="phone",required=false)String phone,
			@RequestParam(value="email",required=false)String email, 
			@RequestParam(value="password",required=true)String password) {
		User user = userService.findUserByPhoneAndEmail(phone, email, password);
		if(null == user) {
			return "NoUser";
		}else {
			Gson gson = new Gson();
			String str = gson.toJson(user);
			return str;
		}
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String regist(@RequestParam(value="phone",required=false)String phone,
			@RequestParam(value="email",required=false)String email, 
			@RequestParam(value="password",required=true)String password) {
		User user = null;
		user = userService.findUserByPhoneAndEmail(phone, email, null);
		if(null != user) {
			return "ERROR"; //已被注册
		}else {
			user = new User();
			user.setPhone(phone);
			user.setEmail(email);
			user.setPassword(password);
			int f = userService.addUser(user);
			System.out.println(user.getUserId());
			if(f > 0) {
				System.out.println("注册成功");
			}
			return "OK";
		}
	}
	
	@RequestMapping(value="/forgetPwd", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String forgetPwd(@RequestParam(value="phone",required=false)String phone,
			@RequestParam(value="email",required=false)String email, 
			@RequestParam(value="password",required=true)String password) {
		if(userService.updateUserPwd(phone, email, password) > 0) {
			System.out.println("密码修改成功");
			return "OK";
		}else {
			System.out.println("密码修改失败");
			return "ERROR";
		}
	}
	
	@RequestMapping(value="/changeMsg", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public String changeMsg(HttpServletRequest request) {
		String str = "";
		User user = new User();
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem fi : items) {
				if(fi.isFormField()) {
					String string = fi.getString("utf-8");
					switch (fi.getFieldName()) {
						case "userId":
							user.setUserId(Integer.parseInt(string));
							break;
						case "phone":
							user.setPhone(string);
							break;
						case "email":
							user.setEmail(string);
							break;
						case "password":
							user.setPassword(string);
							break;
						case "userName":
							user.setUserName(string);
							break;
						case "birth":
							user.setBirth(DateUtil.getDate(string));
							break;
						case "signature":
							user.setSignature(string);
							break;
						case "sex":
							user.setSex(string);
						default:
							break;
					}
				}else {
					String realPath = request.getSession().getServletContext().getRealPath("/");
					fi.write(new File(realPath+"avatar\\"+fi.getName()));
					user.setUserHead("avatar/"+fi.getName());
				}
			}
			System.out.println(user);
			int b = userService.updateMsgOfUser(user);
			if(b > 0) {
				str = "OK";
				System.out.println("修改个人信息成功");
			}else {
				str = "ERROR";
				System.out.println("修改个人信息失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return str;
	}
	
	@RequestMapping(value="/followList", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String followList(@RequestParam("userId")String userId) {
		String string = null;
		List<User> list = userService.findFollowed(userId);
		if(list.size() > 0) {
			Gson gson = new Gson();
			string = gson.toJson(list);
		}
		System.out.println("关注个数："+list.size());
		return string;
	}
	
	@RequestMapping(value="/fansList", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String fansList(@RequestParam("userId")String userId) {
		String string = null;
		List<User> list = userService.findFans(userId);
		if(list.size() > 0) {
			Gson gson = new Gson();
			string = gson.toJson(list);
		}
		System.out.println("粉丝个数："+list.size());
		return string;
	}
	
	@RequestMapping(value="/ifFollow", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String ifFollow(@RequestParam("mineId")String mineId,@RequestParam("otherId")String otherId) {
		Attention attention = new Attention();
		attention.setMineId(Integer.parseInt(mineId));
		attention.setOtherId(Integer.parseInt(otherId));
		int i = userService.findIfAttention(attention);
		if(i > 0) {
			System.out.println("已关注");
			return "YES";
		}else {
			System.out.println("未关注");
			return "NO";
		}
	}
	
	@RequestMapping(value="/follow", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String follow(@RequestParam("mineId")String mineId,@RequestParam("otherId")String otherId) {
		Attention attention = new Attention();
		attention.setMineId(Integer.parseInt(mineId));
		attention.setOtherId(Integer.parseInt(otherId));
		if(userService.addAttention(attention) > 0) {
			System.out.println("关注成功");
			return "OK";
		}else {
			System.out.println("关注失败");
			return "ERROR";
		}
	}
	
	@RequestMapping(value="/noFollow", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String noFollow(@RequestParam("mineId")String mineId,@RequestParam("otherId")String otherId) {
		Attention attention = new Attention();
		attention.setMineId(Integer.parseInt(mineId));
		attention.setOtherId(Integer.parseInt(otherId));
		if(userService.deleteAttention(attention) > 0) {
			System.out.println("取关成功");
			return "OK";
		}else {
			System.out.println("取关失败");
			return "ERROR";
		}
	}
}
