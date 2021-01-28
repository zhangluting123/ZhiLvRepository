package com.zhilv.mailmycomment.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhilv.entity.MailMyComment;
import com.zhilv.mailmycomment.service.MailMyCommentService;


/**   
 * @ClassName: MailMyCommentController   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月27日 上午11:28:11       
 */
@RestController
@RequestMapping("/mailmycomment")
public class MailMyCommentController {
	
	@Resource
	private MailMyCommentService mailMyCommentService;
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String list(@RequestParam("userId")Integer userId) {
		List<MailMyComment> list = this.mailMyCommentService.findMailMyComment(userId);
		if(list.size() > 0) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String str = gson.toJson(list);
			return str;
		}else {
			return null;
		}
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String update(@RequestParam("myCommentId")Integer myCommentId) {
		int n = this.mailMyCommentService.updateReadMsg(myCommentId);
		if(n > 0) {
			return "OK";
		}
		return "ERROR";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String delete(@RequestParam("myCommentId")Integer myCommentId) {
		int n = this.mailMyCommentService.removeMailMyComment(myCommentId);
		if(n > 0) {
			return "OK";
		}
		return "ERROR";
	}
}
