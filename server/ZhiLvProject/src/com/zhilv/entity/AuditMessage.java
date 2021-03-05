package com.zhilv.entity;

import java.util.Date;

/**
 * @ClassName: AuditMessage   
 * @Description:
 * @author: �����
 * @date: 2021��3��4�� ����8:53:40
 */
public class AuditMessage {
	private Integer flag; //1�μǣ�2��Ƶ��3���⣻4����
	private Integer auditId;
	private String title;
	private String content;
	private String address;
	private Date uploadTime;
	private Date lastTime;
	private Integer status;
	
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
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
	
	
}
