package com.zhilv.entity;

/**   
 * @ClassName: Topic   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月19日 下午5:05:54       
 */
public class Topic {
	private Integer topicId;
	private String title;
	private Integer userId;
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
	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", title=" + title + ", userId=" + userId + "]";
	}
	
	
}
