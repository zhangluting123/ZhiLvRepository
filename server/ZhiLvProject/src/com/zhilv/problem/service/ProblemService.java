package com.zhilv.problem.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.Problem;
import com.zhilv.problem.dao.ProblemMapper;

/**   
 * @ClassName: ProblemService   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年2月2日 下午6:45:41       
 */
@Service
public class ProblemService {

	@Resource
	private ProblemMapper problemMapper;
	
	/**
	 * @Title: addProblem
	 * @Description: 添加问题
	 * @author: 张璐婷 
	 * @date: 2021年2月2日 下午6:51:24
	 */
	public int addProblem(String content,Date time,Integer userId) {
		return problemMapper.addProblem(content, time, userId);
	}
	
	/**
	 * @Title: findProblem
	 * @Description: 查询问题
	 * @author: 张璐婷 
	 * @date: 2021年2月2日 下午6:51:51
	 */
	public List<Problem> findAllProblem(){
		return problemMapper.findAllProblem();
	}
	
	/**
	 * @Title: findForPage
	 * @Description: 分页查询
	 * @author: 张璐婷 
	 * @date: 2021年2月2日 下午7:30:21
	 */
	public List<Problem> findForPage(int startIndex,int pageSize){
		return problemMapper.findForPage(startIndex, pageSize);
	}
	
	/**
	 * @Title: findCountProblem
	 * @Description: 查询问题数量
	 * @author: 张璐婷 
	 * @date: 2021年2月2日 下午7:26:36
	 */
	public int findCountProblem() {
		return problemMapper.findCountProblem();
	}
}
