package com.zhilv.mailmycomment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.MailMyComment;


/**   
 * @ClassName: MailMyCommentMapper   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��27�� ����11:28:25       
 */
public interface MailMyCommentMapper {
	
	/**
	 * @Title: insertMailMyComment
	 * @Description: ����һ��֪ͨ��Ϣ
	 * @author: ����� 
	 * @date: 2020��4��24�� ����9:27:49
	 */
	public int insertMailMyComment(@Param("userId")Integer userId,@Param("commentId")Integer commentId,@Param("replyId")Integer replyId,@Param("crflag")Character crflag);
	/**
	 * @Title: queryMailMyComment
	 * @Description: ��ѯ����֪ͨ��Ϣ
	 * @author: ����� 
	 * @date: 2020��4��24�� ����1:36:14
	 */
	public List<MailMyComment> queryMailMyComment(Integer userId);
	
	/**
	 * @Title: updateReadMsg
	 * @Description: ������ϢΪ�Ѷ�
	 * @author: ����� 
	 * @date: 2020��4��25�� ����12:44:51
	 */
	public int updateReadMsg(Integer myCommentId);
		
	/**
	 * @Title: deleteMailMyComment
	 * @Description: ɾ����Ϣ
	 * @author: ����� 
	 * @date: 2020��4��25�� ����2:52:11
	 */
	public int deleteMailMyComment(Integer myCommentId);
}
