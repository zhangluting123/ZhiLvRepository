package com.zhilv.entity;

import java.util.Date;
import java.util.List;

/**   
 * @ClassName: AuditTravels   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月20日 下午4:34:23       
 */
public class AuditTravels {
	private Integer auditId;
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
	private Integer userId;
	private Date lastTime;
	private Integer status;
	private List<Img> imgList;
	
	
	public Integer getAuditId() {
		return auditId;
	}
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}
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
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<Img> getImgList() {
		return imgList;
	}
	public void setImgList(List<Img> imgList) {
		this.imgList = imgList;
	}
	@Override
	public String toString() {
		return "AuditTravels [auditId=" + auditId + ", travelsId=" + travelsId + ", title=" + title + ", route=" + route
				+ ", scene=" + scene + ", ticket=" + ticket + ", hotel=" + hotel + ", tips=" + tips + ", topic=" + topic
				+ ", location=" + location + ", uploadTime=" + uploadTime + ", detail=" + detail + ", userId=" + userId
				+ ", lastTime=" + lastTime + ", status=" + status + ", imgList=" + imgList + "]";
	}
	
	
	
}
