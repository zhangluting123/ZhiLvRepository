package com.zhilv.replycomment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.ReplyComment;


/**   
 * @ClassName: ReplyCommentMapper   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��27�� ����10:32:45       
 */
public interface ReplyCommentMapper {
	
	/**
	 * @Title: insertReplyComment
	 * @Description: �������۵Ļظ�
	 * @author: ����� 
	 * @date: 2021��1��27�� ����12:58:33
	 */
	public int insertReplyComment(@Param("reply")ReplyComment replyComment);
	
	/**
	 * @Title: queryCountOfReplyByCommentId
	 * @Description: ��ѯ�ظ����۵�����
	 * @author: ����� 
	 * @date: 2021��1��27�� ����12:58:33
	 */
	public int queryCountOfReplyByCommentId(Integer commentId);
	
	
	/**
	 * @Title: queryReplyCommentByCommentId
	 * @Description: ��������ID��ѯ���лظ�����
	 * @author: ����� 
	 * @date: 2021��1��27�� ����12:58:33
	 */
	public List<ReplyComment> queryReplyCommentByCommentId(Integer commentId);
	
	/**
	 * @Title: queryReplyCommentById
	 * @Description: ����ID��ѯ�ظ�����
	 * @author: ����� 
	 * @date: 2021��1��27�� ����12:58:33
	 */
	public ReplyComment queryReplyCommentById1(Integer replyId);
	public ReplyComment queryReplyCommentById2(Integer replyId);
	
	/**
	 * @Title: insertReplyToReply
	 * @Description: ����ظ��Ļظ�
	 * @author: ����� 
	 * @date: 2021��1��27�� ����12:58:33
	 */
	public  int insertReplyToReply(@Param("reply")ReplyComment replyComment);
}
