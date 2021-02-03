package com.zhilv.entity;

import java.util.Date;

/**   
 * @ClassName: Note   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月22日 下午4:35:07       
 */
public class Note {
	private boolean flag;  //flag=true 游记; flag=false 视频
	private Date time;
	private Travels travels;
	private Video video;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Travels getTravels() {
		return travels;
	}
	public void setTravels(Travels travels) {
		this.travels = travels;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}

}
