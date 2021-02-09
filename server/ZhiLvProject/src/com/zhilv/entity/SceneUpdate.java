package com.zhilv.entity;

import java.util.Date;

/**   
 * @ClassName: SceneUpdate   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年2月8日 上午9:16:59       
 */
public class SceneUpdate {
	private Integer updateId;
	private User user;
	private Integer sceneId;
	private Date updateTime;
	public Integer getUpdateId() {
		return updateId;
	}
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getSceneId() {
		return sceneId;
	}
	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	

}
