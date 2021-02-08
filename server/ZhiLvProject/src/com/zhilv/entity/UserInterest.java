/**
 * 
 */
package com.zhilv.entity;

/**
 * @ClassName:UserInterest
 * @description:TODO
 * @author :张梦如
 * @date:2021年2月8日
 */
public class UserInterest {
	
	private Integer interestId;
	private Integer userId;
	private Integer labelId;
	private Integer weight;
	/**
	 * @return the interestId
	 */
	public Integer getInterestId() {
		return interestId;
	}
	/**
	 * @param interestId the interestId to set
	 */
	public void setInterestId(Integer interestId) {
		this.interestId = interestId;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the labelId
	 */
	public Integer getLabelId() {
		return labelId;
	}
	/**
	 * @param labelId the labelId to set
	 */
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
	/**
	 * @return the weight
	 */
	public Integer getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "UserInterest [interestId=" + interestId + ", userId=" + userId + ", labelId=" + labelId +", weight=" + weight+"]";
	}

}
