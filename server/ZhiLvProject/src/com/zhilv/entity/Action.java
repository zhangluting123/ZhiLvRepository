/**
 * 
 */
package com.zhilv.entity;

/**
 * @ClassName:Action
 * @description:TODO
 * @author :张梦如
 * @date:2021年2月8日
 */
public class Action {
	private Integer actionId;
	private String actionName;
	private Integer weight;
	/**
	 * @return the actionId
	 */
	public Integer getActionId() {
		return actionId;
	}
	/**
	 * @param actionId the actionId to set
	 */
	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}
	/**
	 * @return the actionName
	 */
	public String getActionName() {
		return actionName;
	}
	/**
	 * @param actionName the actionName to set
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
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
		return "Action [actionId=" + actionId + ", actionName=" + actionName + ", weight=" + weight+"]";
	}

}
