package com.zhilv.audit.user.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhilv.entity.User;
import com.zhilv.user.service.UserService;
import com.zhilv.util.FinalUtil;
import com.zhilv.util.Page;

/**   
 * @ClassName: AuditUserController   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年2月2日 下午7:51:56       
 */
@Controller
@RequestMapping("audit/user")
public class AuditUserController {

	@Resource
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@RequestParam("userId")Integer userId) {
		int i = userService.deleteUserById(userId);
		if(i > 0) {
			System.out.println("删除成功");
			return "OK";
		}else {
			System.out.println("删除失败");
			return "ERROR";
		}
	}
	
	@RequestMapping(value="/list/{pageNum}",method=RequestMethod.GET)
	public String list(Model model,@PathVariable("pageNum")int pageNum) {
		List<User> list = userService.findForPage((pageNum-1)*FinalUtil.PAGE_SIZE, FinalUtil.PAGE_SIZE);
		Page<User> page = new Page<>(pageNum, FinalUtil.PAGE_SIZE);
		page.setList(list);
		page.setTotalCount(userService.findCountUser());
		model.addAttribute("userPage", page);
		return "index";
	}
}
