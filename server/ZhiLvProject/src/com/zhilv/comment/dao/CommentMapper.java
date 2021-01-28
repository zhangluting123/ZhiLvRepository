package com.zhilv.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.Comment;

/**   
 * @ClassName: CommentMapper   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月27日 上午10:31:27       
 */
public interface CommentMapper {
	
	/**
	 * @Title: findCommentByNoteId
	 * @Description: 根据travelsId或videoId查询所有评论
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 上午10:42:36
	 */
	public List<Comment> findCommentByNoteId(@Param("travelsId")Integer travelsId,@Param("videoId")Integer videoId);
	
	/**
	 * @Title: addComment
	 * @Description: 添加评论
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 上午10:43:50
	 */
	public int addComment(@Param("comment")Comment comment);
	
	/**
	 * @Title: findCommentById
	 * @Description: 查找某一条评论
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 上午10:44:40
	 */
	public Comment findCommentById(@Param("commentId")Integer commentId);
}
