package com.zhilv.replycomment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.ReplyComment;


/**   
 * @ClassName: ReplyCommentMapper   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月27日 上午10:32:45       
 */
public interface ReplyCommentMapper {
	
	/**
	 * @Title: insertReplyComment
	 * @Description: 插入评论的回复
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 下午12:58:33
	 */
	public int insertReplyComment(@Param("reply")ReplyComment replyComment);
	
	/**
	 * @Title: queryCountOfReplyByCommentId
	 * @Description: 查询回复评论的数量
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 下午12:58:33
	 */
	public int queryCountOfReplyByCommentId(Integer commentId);
	
	
	/**
	 * @Title: queryReplyCommentByCommentId
	 * @Description: 根据评论ID查询所有回复评论
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 下午12:58:33
	 */
	public List<ReplyComment> queryReplyCommentByCommentId(Integer commentId);
	
	/**
	 * @Title: queryReplyCommentById
	 * @Description: 根据ID查询回复评论
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 下午12:58:33
	 */
	public ReplyComment queryReplyCommentById1(Integer replyId);
	public ReplyComment queryReplyCommentById2(Integer replyId);
	
	/**
	 * @Title: insertReplyToReply
	 * @Description: 插入回复的回复
	 * @author: 张璐婷 
	 * @date: 2021年1月27日 下午12:58:33
	 */
	public  int insertReplyToReply(@Param("reply")ReplyComment replyComment);
}
