package com.zhilv.entity;

import java.util.List;

/**   
 * @ClassName: Scene   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年2月8日 上午9:16:42       
 */
public class Scene {
	private Integer sceneId;
	private String address;
	private String path;
	private String title;
	private String content;
	private String rule;
	private String openTime;
	private String traffic;
	private String ticket;
	private String costTime;
	private String phone;
	private String website;
	private Double latitude;
	private Double longitude;
	private List<SceneUpdate> sceneUpdate;
	public Integer getSceneId() {
		return sceneId;
	}
	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getCostTime() {
		return costTime;
	}
	public void setCostTime(String costTime) {
		this.costTime = costTime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public List<SceneUpdate> getSceneUpdate() {
		return sceneUpdate;
	}
	public void setSceneUpdate(List<SceneUpdate> sceneUpdate) {
		this.sceneUpdate = sceneUpdate;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	
}
