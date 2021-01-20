package com.zhilv.entity;

import java.util.Date;

/**   
 * @ClassName: AuditTopic   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月19日 下午5:06:12       
 */
public class AuditTopic {
	private Integer auditId;
	private Integer topicId;
	private String title;
	private Integer userId;
	private Integer status;
	private Date time;
	public Integer getAuditId() {
		return auditId;
	}
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "AuditTopic [auditId=" + auditId + ", topicId=" + topicId + ", title=" + title + ", userId=" + userId
				+ ", status=" + status + ", time=" + time + "]";
	}
	
}
