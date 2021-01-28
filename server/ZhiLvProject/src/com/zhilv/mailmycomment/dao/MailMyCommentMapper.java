package com.zhilv.mailmycomment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.MailMyComment;


/**   
 * @ClassName: MailMyCommentMapper   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月27日 上午11:28:25       
 */
public interface MailMyCommentMapper {
	
	/**
	 * @Title: insertMailMyComment
	 * @Description: 插入一条通知消息
	 * @author: 张璐婷 
	 * @date: 2020年4月24日 上午9:27:49
	 */
	public int insertMailMyComment(@Param("userId")Integer userId,@Param("commentId")Integer commentId,@Param("replyId")Integer replyId,@Param("crflag")Character crflag);
	/**
	 * @Title: queryMailMyComment
	 * @Description: 查询所有通知消息
	 * @author: 张璐婷 
	 * @date: 2020年4月24日 下午1:36:14
	 */
	public List<MailMyComment> queryMailMyComment(Integer userId);
	
	/**
	 * @Title: updateReadMsg
	 * @Description: 更新信息为已读
	 * @author: 张璐婷 
	 * @date: 2020年4月25日 下午12:44:51
	 */
	public int updateReadMsg(Integer myCommentId);
		
	/**
	 * @Title: deleteMailMyComment
	 * @Description: 删除消息
	 * @author: 张璐婷 
	 * @date: 2020年4月25日 下午2:52:11
	 */
	public int deleteMailMyComment(Integer myCommentId);
}
