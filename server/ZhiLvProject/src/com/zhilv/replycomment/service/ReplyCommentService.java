package com.zhilv.replycomment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.ReplyComment;
import com.zhilv.replycomment.dao.ReplyCommentMapper;

/**   
 * @ClassName: ReplyCommentService   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月27日 上午10:33:34       
 */
@Service
public class ReplyCommentService {
	
	@Resource
	private ReplyCommentMapper replyCommentMapper;
	
	/**
	 * @Title: insertReplyComment
	 * @Description: 插入评论的回复
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 下午12:58:33
	 */
	public int insertReplyComment(ReplyComment replyComment) {
		return replyCommentMapper.insertReplyComment(replyComment);
	}
	
	/**
	 * @Title: queryCountOfReplyByCommentId
	 * @Description: 查询回复评论的数量
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 下午12:58:33
	 */
	public int queryCountOfReplyByCommentId(Integer commentId) {
		return replyCommentMapper.queryCountOfReplyByCommentId(commentId);
	}
	
	
	/**
	 * @Title: queryReplyCommentByCommentId
	 * @Description: 根据评论ID查询所有回复评论
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 下午12:58:33
	 */
	public List<ReplyComment> queryReplyCommentByCommentId(Integer commentId){
		return replyCommentMapper.queryReplyCommentByCommentId(commentId);
	}
	
	/**
	 * @Title: queryReplyCommentById
	 * @Description: 根据ID查询回复评论
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 下午12:58:33
	 */
	public ReplyComment queryReplyCommentById1(Integer replyId) {
		return replyCommentMapper.queryReplyCommentById1(replyId);
	}
	public ReplyComment queryReplyCommentById2(Integer replyId) {
		return replyCommentMapper.queryReplyCommentById2(replyId);
	}
	
	/**
	 * @Title: insertReplyToReply
	 * @Description: 插入回复的回复
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 下午12:58:33
	 */
	public  int insertReplyToReply(ReplyComment replyComment) {
		return replyCommentMapper.insertReplyToReply(replyComment);
	}

}
