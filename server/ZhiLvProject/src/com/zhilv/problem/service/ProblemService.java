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
 * @author: �����
 * @date: 2021��2��2�� ����6:45:41       
 */
@Service
public class ProblemService {

	@Resource
	private ProblemMapper problemMapper;
	
	/**
	 * @Title: addProblem
	 * @Description: �������
	 * @author: ����� 
	 * @date: 2021��2��2�� ����6:51:24
	 */
	public int addProblem(String content,Date time,Integer userId) {
		return problemMapper.addProblem(content, time, userId);
	}
	
	/**
	 * @Title: findProblem
	 * @Description: ��ѯ����
	 * @author: ����� 
	 * @date: 2021��2��2�� ����6:51:51
	 */
	public List<Problem> findAllProblem(){
		return problemMapper.findAllProblem();
	}
	
	/**
	 * @Title: findForPage
	 * @Description: ��ҳ��ѯ
	 * @author: ����� 
	 * @date: 2021��2��2�� ����7:30:21
	 */
	public List<Problem> findForPage(int startIndex,int pageSize){
		return problemMapper.findForPage(startIndex, pageSize);
	}
	
	/**
	 * @Title: findCountProblem
	 * @Description: ��ѯ��������
	 * @author: ����� 
	 * @date: 2021��2��2�� ����7:26:36
	 */
	public int findCountProblem() {
		return problemMapper.findCountProblem();
	}
}
