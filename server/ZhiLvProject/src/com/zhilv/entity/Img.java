package com.zhilv.entity;

/**   
 * @ClassName: AuditImg   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��20�� ����4:36:04       
 */
public class Img {
	private Integer imgId;
	private String path;
	private Integer travelsId;
	public Integer getImgId() {
		return imgId;
	}
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getTravelsId() {
		return travelsId;
	}
	public void setTravelsId(Integer travelsId) {
		this.travelsId = travelsId;
	}
	@Override
	public String toString() {
		return "Img [imgId=" + imgId + ", path=" + path + ", travelsId=" + travelsId + "]";
	}
	
	
}
