package com.zhilv.comment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.comment.dao.CommentMapper;
import com.zhilv.entity.Comment;

/**   
 * @ClassName: CommentService   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月27日 上午10:32:00       
 */
@Service
public class CommentService {
	
	@Resource
	private CommentMapper commentMapper;
	/**
	 * @Title: findCommentByNoteId
	 * @Description: 根据travelsId或videoId查询所有评论
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 上午10:42:36
	 */
	public List<Comment> findCommentByNoteId(Integer travelsId,Integer videoId){
		return commentMapper.findCommentByNoteId(travelsId, videoId);
	}
	
	/**
	 * @Title: addComment
	 * @Description: 添加评论
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 上午10:43:50
	 */
	public int addComment(Comment comment) {
		return commentMapper.addComment(comment);
	}
	
	/**
	 * @Title: findCommentById
	 * @Description: 查找某一条评论
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 上午10:44:40
	 */
	public Comment findCommentById(Integer commentId) {
		return commentMapper.findCommentById(commentId);
	}
}
