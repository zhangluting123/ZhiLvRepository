package com.zhilv.problem.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.Problem;

/**   
 * @ClassName: ProblemMapper   
 * @Description:TODO
 * @author: �����
 * @date: 2021��2��2�� ����6:45:11       
 */
public interface ProblemMapper {
	
	/**
	 * @Title: addProblem
	 * @Description: �������
	 * @author: ����� 
	 * @date: 2021��2��2�� ����6:51:24
	 */
	public int addProblem(@Param("content")String content,@Param("time")Date time,@Param("userId")Integer userId);
	
	/**
	 * @Title: findProblem
	 * @Description: ��ѯ����
	 * @author: ����� 
	 * @date: 2021��2��2�� ����6:51:51
	 */
	public List<Problem> findAllProblem();
	
	/**
	 * @Title: findForPage
	 * @Description: ��ҳ��ѯ
	 * @author: ����� 
	 * @date: 2021��2��2�� ����7:30:21
	 */
	public List<Problem> findForPage(int startIndex,int pageSize);

	/**
	 * @Title: findCountProblem
	 * @Description: ��ѯ��������
	 * @author: ����� 
	 * @date: 2021��2��2�� ����7:26:36
	 */
	public int findCountProblem();
}
