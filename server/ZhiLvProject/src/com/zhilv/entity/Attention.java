package com.zhilv.entity;

/**   
 * @ClassName: Attention   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月17日 下午4:10:50       
 */
public class Attention {
	private Integer attentionId;
	private Integer mineId;
	private Integer otherId;
	
	public Integer getAttentionId() {
		return attentionId;
	}
	public void setAttentionId(Integer attentionId) {
		this.attentionId = attentionId;
	}
	public Integer getMineId() {
		return mineId;
	}
	public void setMineId(Integer mineId) {
		this.mineId = mineId;
	}
	public Integer getOtherId() {
		return otherId;
	}
	public void setOtherId(Integer otherId) {
		this.otherId = otherId;
	}
	
	@Override
	public String toString() {
		return "Attention [attentionId=" + attentionId + ", mineId=" + mineId + ", otherId=" + otherId + "]";
	}
	

}
