package com.zhilv.entity;

import java.util.Date;
import java.util.List;

/**   
 * @ClassName: Travels   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月20日 下午4:56:39       
 */
public class Travels {
	private Integer travelsId;
	private String title;
	private String route;
	private String scene;
	private String ticket;
	private String hotel;
	private String tips;
	private Topic topic;
	private String location;
	private Date uploadTime;
	private MoreDetail detail;
	private List<Img> imgList;
	private User user;
	public Integer getTravelsId() {
		return travelsId;
	}
	public void setTravelsId(Integer travelsId) {
		this.travelsId = travelsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getScene() {
		return scene;
	}
	public void setScene(String scene) {
		this.scene = scene;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public MoreDetail getDetail() {
		return detail;
	}
	public void setDetail(MoreDetail detail) {
		this.detail = detail;
	}
	public List<Img> getImgList() {
		return imgList;
	}
	public void setImgList(List<Img> imgList) {
		this.imgList = imgList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
