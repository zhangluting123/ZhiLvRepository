package com.zhilv.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.Comment;

/**   
 * @ClassName: CommentMapper   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��27�� ����10:31:27       
 */
public interface CommentMapper {
	
	/**
	 * @Title: findCommentByNoteId
	 * @Description: ����travelsId��videoId��ѯ��������
	 * @author: ����� 
	 * @date: 2021��1��27�� ����10:42:36
	 */
	public List<Comment> findCommentByNoteId(@Param("travelsId")Integer travelsId,@Param("videoId")Integer videoId);
	
	/**
	 * @Title: addComment
	 * @Description: �������
	 * @author: ����� 
	 * @date: 2021��1��27�� ����10:43:50
	 */
	public int addComment(@Param("comment")Comment comment);
	
	/**
	 * @Title: findCommentById
	 * @Description: ����ĳһ������
	 * @author: ����� 
	 * @date: 2021��1��27�� ����10:44:40
	 */
	public Comment findCommentById(@Param("commentId")Integer commentId);
}
