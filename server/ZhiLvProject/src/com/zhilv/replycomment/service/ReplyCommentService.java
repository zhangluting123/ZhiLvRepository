package com.zhilv.replycomment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.ReplyComment;
import com.zhilv.replycomment.dao.ReplyCommentMapper;

/**   
 * @ClassName: ReplyCommentService   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��27�� ����10:33:34       
 */
@Service
public class ReplyCommentService {
	
	@Resource
	private ReplyCommentMapper replyCommentMapper;
	
	/**
	 * @Title: insertReplyComment
	 * @Description: �������۵Ļظ�
	 * @author: ����� 
	 * @date: 2021��1��27�� ����12:58:33
	 */
	public int insertReplyComment(ReplyComment replyComment) {
		return replyCommentMapper.insertReplyComment(replyComment);
	}
	
	/**
	 * @Title: queryCountOfReplyByCommentId
	 * @Description: ��ѯ�ظ����۵�����
	 * @author: ����� 
	 * @date: 2021��1��27�� ����12:58:33
	 */
	public int queryCountOfReplyByCommentId(Integer commentId) {
		return replyCommentMapper.queryCountOfReplyByCommentId(commentId);
	}
	
	
	/**
	 * @Title: queryReplyCommentByCommentId
	 * @Description: ��������ID��ѯ���лظ�����
	 * @author: ����� 
	 * @date: 2021��1��27�� ����12:58:33
	 */
	public List<ReplyComment> queryReplyCommentByCommentId(Integer commentId){
		return replyCommentMapper.queryReplyCommentByCommentId(commentId);
	}
	
	/**
	 * @Title: queryReplyCommentById
	 * @Description: ����ID��ѯ�ظ�����
	 * @author: ����� 
	 * @date: 2021��1��27�� ����12:58:33
	 */
	public ReplyComment queryReplyCommentById1(Integer replyId) {
		return replyCommentMapper.queryReplyCommentById1(replyId);
	}
	public ReplyComment queryReplyCommentById2(Integer replyId) {
		return replyCommentMapper.queryReplyCommentById2(replyId);
	}
	
	/**
	 * @Title: insertReplyToReply
	 * @Description: ����ظ��Ļظ�
	 * @author: ����� 
	 * @date: 2021��1��27�� ����12:58:33
	 */
	public  int insertReplyToReply(ReplyComment replyComment) {
		return replyCommentMapper.insertReplyToReply(replyComment);
	}

}
