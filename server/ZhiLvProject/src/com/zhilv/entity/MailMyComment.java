package com.zhilv.entity;

/**
 * @ClassName: MailMyComment   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月27日 上午11:25:09
 */
public class MailMyComment {
	private Integer id;
	private User user;
	private Comment comment;
	private ReplyComment replyComment;
	private Character crFlag;
	private Integer readFlag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public ReplyComment getReplyComment() {
		return replyComment;
	}

	public void setReplyComment(ReplyComment replyComment) {
		this.replyComment = replyComment;
	}

	public Character getCrFlag() {
		return crFlag;
	}

	public void setCrFlag(Character crFlag) {
		this.crFlag = crFlag;
	}

	public Integer getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(Integer readFlag) {
		this.readFlag = readFlag;
	}
	
	
}
