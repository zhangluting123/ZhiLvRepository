package com.zhilv.entity;

import java.util.Date;

/**   
 * @ClassName: User   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月16日 下午5:09:58       
 */
public class User {
	private Integer userId;
	private String phone;
	private String email;
	private String password;
	private String userHead;
	private String userName;
	private String sex;
	private Date birth;
	private String signature;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserHead() {
		return userHead;
	}
	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", phone=" + phone + ", email=" + email + ", password=" + password
				+ ", userHead=" + userHead + ", userName=" + userName + ", sex=" + sex + ", birth=" + birth
				+ ", signature=" + signature + "]";
	}
	
	
	
	
}
