package com.zhilv.entity;

import java.util.Date;

/**
 * 
 * @ClassName: Comment   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月27日 上午10:39:27
 */
public class Comment {
	private Integer id;
	private String content;
	private Date time;
	private User user;
	private Integer replyCount;  //回复数量
	private Travels travels;
	private Video video;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
	public Travels getTravels() {
		return travels;
	}
	public void setTravels(Travels travels) {
		this.travels = travels;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	
}
