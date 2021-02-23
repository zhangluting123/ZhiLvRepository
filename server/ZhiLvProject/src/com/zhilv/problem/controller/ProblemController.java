package com.zhilv.problem.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhilv.entity.Problem;
import com.zhilv.problem.service.ProblemService;
import com.zhilv.util.DateUtil;
import com.zhilv.util.FinalUtil;
import com.zhilv.util.Page;

/**   
 * @ClassName: ProblemController   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年2月2日 下午6:44:58       
 */
@Controller
@RequestMapping("problem")
public class ProblemController {
	
	@Resource
	private ProblemService problemService;
	
	@RequestMapping(value="/list/{pageNum}",method=RequestMethod.GET)
	public String list(Model model,@PathVariable("pageNum")int pageNum) {
		List<Problem> list = problemService.findForPage((pageNum-1)*FinalUtil.PAGE_SIZE, FinalUtil.PAGE_SIZE);
		Page<Problem> page = new Page<>(pageNum,FinalUtil.PAGE_SIZE);
		page.setList(list);
		page.setTotalCount(problemService.findCountProblem());
		model.addAttribute("problemPage", page);
		return "problem-list";
	}
	
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@RequestParam("content")String content,
			@RequestParam("userId")Integer userId) {
		int i = problemService.addProblem(content, DateUtil.getCurrentTimes(), userId);
		if(i > 0) {
			System.out.println("问题添加成功");
			return "OK";
		}else {
			System.out.println("问题添加失败");
			return "ERROR";
		}
	}
}
