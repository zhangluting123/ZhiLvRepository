package com.zhilv.entity;

import java.util.Date;

/**   
 * @ClassName: Note   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��22�� ����4:35:07       
 */
public class Note {
	private boolean flag;  //flag=true �μ�; flag=false ��Ƶ
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
