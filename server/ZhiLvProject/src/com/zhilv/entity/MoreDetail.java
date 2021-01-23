package com.zhilv.entity;

import java.util.Date;

/**   
 * @ClassName: MoreDetail   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月20日 下午4:48:49       
 */
public class MoreDetail {
	private Integer moreId;
	private String destination;
	private String traffic;
	private Date beginDate;
	private Integer days;
	private String people;
	private Integer money;
	private Integer travelsId;
	private Integer videoId;
	public Integer getMoreId() {
		return moreId;
	}
	public void setMoreId(Integer moreId) {
		this.moreId = moreId;
	}
	public String getDestination() {
		return destination;
	}
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public Integer getTravelsId() {
		return travelsId;
	}
	public void setTravelsId(Integer travelsId) {
		this.travelsId = travelsId;
	}
	public Integer getVideoId() {
		return videoId;
	}
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}
	@Override
	public String toString() {
		return "MoreDetail [moreId=" + moreId + ", destination=" + destination + ", traffic=" + traffic + ", beginDate="
				+ beginDate + ", days=" + days + ", people=" + people + ", money=" + money + ", travelsId=" + travelsId
				+ ", videoId=" + videoId + "]";
	}
	
	
}
