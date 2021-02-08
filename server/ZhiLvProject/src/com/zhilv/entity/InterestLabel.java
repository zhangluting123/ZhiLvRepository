/**
 * 
 */
package com.zhilv.entity;

/**
 * @ClassName:InterestLabel
 * @description:TODO
 * @author :张梦如
 * @date:2021年2月8日
 */
public class InterestLabel {
	
	private Integer labelId;
	private String labelName;
	private String labelType;
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
	 * @return the labelName
	 */
	public String getLabelName() {
		return labelName;
	}
	/**
	 * @param labelName the labelName to set
	 */
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	/**
	 * @return the labelType
	 */
	public String getLabelType() {
		return labelType;
	}
	/**
	 * @param labelType the labelType to set
	 */
	public void setLabelType(String labelType) {
		this.labelType = labelType;
	}
	
	@Override
	public String toString() {
		return "InterestLabel [labelId=" + labelId + ", labelName=" + labelName + ", labelType=" + labelType+"]";
	}
}
