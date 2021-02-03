package com.zhilv.entity;

import java.util.Date;

/**   
 * @ClassName: AuditVideo   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月25日 上午11:30:22       
 */
public class AuditVideo {
	private Integer auditId;
	private Integer videoId;
	private String path;
	private String img;
	private String title;
	private String content;
	private Topic topic;
	private String location;
	private String duration;
	private String size;
	private Date uploadTime;
	private MoreDetail detail;
	private Integer userId;
	private Date lastTime;
	private Integer status;
	
	public Integer getAuditId() {
		return auditId;
	}
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}
	public Integer getVideoId() {
		return videoId;
	}
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	@Override
	public String toString() {
		return "AuditVideo [auditId=" + auditId + ", videoId=" + videoId + ", path=" + path + ", img=" + img
				+ ", title=" + title + ", content=" + content + ", topic=" + topic + ", location=" + location
				+ ", duration=" + duration + ", size=" + size + ", uploadTime=" + uploadTime + ", detail=" + detail
				+ ", userId=" + userId + ", lastTime=" + lastTime + ", status=" + status + "]";
	}

	
}
