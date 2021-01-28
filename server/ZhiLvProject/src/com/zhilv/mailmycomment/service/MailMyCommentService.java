package com.zhilv.mailmycomment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.MailMyComment;
import com.zhilv.mailmycomment.dao.MailMyCommentMapper;


/**   
 * @ClassName: MailMyCommentService   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��27�� ����11:29:01       
 */
@Service
public class MailMyCommentService {

	@Resource
	private MailMyCommentMapper mailMyCommentMapper;
	
	/**
	 * @Title: addMailMyCommentService
	 * @Description: ���������Ϣ
	 * @author: ����� 
	 * @date: 2020��4��24�� ����9:39:34
	 */
	public int addMailMyCommentService(Integer userId,Integer commentId,Integer replyId,Character crflag) {
		return this.mailMyCommentMapper.insertMailMyComment(userId, commentId, replyId, crflag);
	}
	
	/**
	 * @Title: findMailMyComment
	 * @Description: ��ѯ����֪ͨ��Ϣ
	 * @author: ����� 
	 * @date: 2020��4��24�� ����4:12:21
	 */
	public List<MailMyComment> findMailMyComment(Integer userId){
		return this.mailMyCommentMapper.queryMailMyComment(userId);
	}
	
	/**
	 * @Title: updateReadMsg
	 * @Description: �����Ķ���Ϣ
	 * @author: ����� 
	 * @date: 2020��4��25�� ����12:49:34
	 */
	public int updateReadMsg(Integer myCommentId) {
		return this.mailMyCommentMapper.updateReadMsg(myCommentId);
	}
	
	/**
	 * @Title: removeMailMyComment
	 * @Description: ɾ����Ϣ
	 * @author: ����� 
	 * @date: 2020��4��25�� ����2:53:16
	 */
	public int removeMailMyComment(Integer myCommentId) {
		return this.mailMyCommentMapper.deleteMailMyComment(myCommentId);
	}
}
