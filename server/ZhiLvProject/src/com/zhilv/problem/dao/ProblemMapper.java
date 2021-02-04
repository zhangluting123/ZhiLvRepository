package com.zhilv.problem.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.Problem;

/**   
 * @ClassName: ProblemMapper   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年2月2日 下午6:45:11       
 */
public interface ProblemMapper {
	
	/**
	 * @Title: addProblem
	 * @Description: 添加问题
	 * @author: 张璐婷 
	 * @date: 2021年2月2日 下午6:51:24
	 */
	public int addProblem(@Param("content")String content,@Param("time")Date time,@Param("userId")Integer userId);
	
	/**
	 * @Title: findProblem
	 * @Description: 查询问题
	 * @author: 张璐婷 
	 * @date: 2021年2月2日 下午6:51:51
	 */
	public List<Problem> findAllProblem();
	
	/**
	 * @Title: findForPage
	 * @Description: 分页查询
	 * @author: 张璐婷 
	 * @date: 2021年2月2日 下午7:30:21
	 */
	public List<Problem> findForPage(int startIndex,int pageSize);

	/**
	 * @Title: findCountProblem
	 * @Description: 查询问题数量
	 * @author: 张璐婷 
	 * @date: 2021年2月2日 下午7:26:36
	 */
	public int findCountProblem();
}
