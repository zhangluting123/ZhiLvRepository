package com.zhilv.entity;

import java.util.Date;

/**   
 * @ClassName: UserCollection   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��30�� ����11:08:04       
 */
public class UserCollection {
	private Integer id;
	private User user;
	private Travels travels;
	private Video video;
	private Date time;
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	

}
