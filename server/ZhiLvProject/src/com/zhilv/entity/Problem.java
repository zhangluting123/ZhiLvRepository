package com.zhilv.entity;

import java.util.Date;

/**   
 * @ClassName: Problem   
 * @Description:TODO
 * @author: �����
 * @date: 2021��2��2�� ����6:47:58       
 */
public class Problem {
	private Integer id;
	private String content;
	private Date time;
	private User user;
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
	
}
