package com.zhilv.entity;

import java.util.Date;

/**
 * @ClassName: Views   
 * @Description:
 * @author: 张璐婷
 * @date: 2021年2月10日 下午2:59:08
 */
public class Views {
	private Integer viewsId;
	private User user;
	private Travels travels;
	private Video video;
	private Scene scene;
	private Date time;
	public Integer getViewsId() {
		return viewsId;
	}
	public void setViewsId(Integer viewsId) {
		this.viewsId = viewsId;
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
	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	

}
