package com.zhilv.comment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.comment.dao.CommentMapper;
import com.zhilv.entity.Comment;

/**   
 * @ClassName: CommentService   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��27�� ����10:32:00       
 */
@Service
public class CommentService {
	
	@Resource
	private CommentMapper commentMapper;
	/**
	 * @Title: findCommentByNoteId
	 * @Description: ����travelsId��videoId��ѯ��������
	 * @author: ����� 
	 * @date: 2021��1��27�� ����10:42:36
	 */
	public List<Comment> findCommentByNoteId(Integer travelsId,Integer videoId){
		return commentMapper.findCommentByNoteId(travelsId, videoId);
	}
	
	/**
	 * @Title: addComment
	 * @Description: �������
	 * @author: ����� 
	 * @date: 2021��1��27�� ����10:43:50
	 */
	public int addComment(Comment comment) {
		return commentMapper.addComment(comment);
	}
	
	/**
	 * @Title: findCommentById
	 * @Description: ����ĳһ������
	 * @author: ����� 
	 * @date: 2021��1��27�� ����10:44:40
	 */
	public Comment findCommentById(Integer commentId) {
		return commentMapper.findCommentById(commentId);
	}
}
