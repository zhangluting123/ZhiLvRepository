package com.zhilv.entity;

import java.util.Date;

/**   
 * @ClassName: AuditTopic   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��19�� ����5:06:12       
 */
public class AuditTopic {
	private Integer auditId;
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

	
}
