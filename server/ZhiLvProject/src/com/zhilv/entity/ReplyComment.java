package com.zhilv.entity;

import java.util.Date;

/**
 * 
 * @ClassName: ReplyComment   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��27�� ����10:39:21
 */
public class ReplyComment {
	private Integer replyId;
	private Comment comment;
	private User replyUser;
	private String replyContent;
	private Date replyTime;
	private ReplyComment replyComment;
	
	public Integer getReplyId() {
		return replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public User getReplyUser() {
		return replyUser;
	}
	public void setReplyUser(User replyUser) {
		this.replyUser = replyUser;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public ReplyComment getReplyComment() {
		return replyComment;
	}

	public void setReplyComment(ReplyComment replyComment) {
		this.replyComment = replyComment;
	}
	
	
}
