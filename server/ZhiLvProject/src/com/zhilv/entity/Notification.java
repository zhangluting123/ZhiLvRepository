package com.zhilv.entity;

import java.util.Date;

/**   
 * @ClassName: Notification   
 * @Description: 消息实体类
 * @author: 张璐婷
 * @date: 2021年1月13日 下午4:30:41       
 */
public class Notification {
	private Integer id;
	private String title;
	private String content;
	private Date time;
	private Integer userId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
