package com.zhilv.audit.travels.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.audit.travels.dao.AuditTravelsMapper;
import com.zhilv.entity.AuditTravels;
import com.zhilv.entity.Img;
import com.zhilv.entity.MoreDetail;

/**   
 * @ClassName: AuditTravelsService   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月20日 下午4:56:16       
 */
@Service
public class AuditTravelsService {
	@Resource
	private AuditTravelsMapper auditTravelsMapper;
	
	/**
	 * @Title: addAuditTravels
	 * @Description: 添加审核版游记
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午6:36:34
	 */
	public int addAuditTravels(AuditTravels auditTravels) {
		return auditTravelsMapper.addAuditTravels(auditTravels);
	}
	
	/**
	 * @Title: addTravelsImg
	 * @Description: 添加图片
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午7:03:40
	 */
	public int addTravelsImg(List<Img> imgs) {
		return auditTravelsMapper.addTravelsImg(imgs);
	}
	
	/**
	 * @Title: addTravelsDetail
	 * @Description: 添加详细信息
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午7:04:58
	 */
	public int addTravelsDetail(MoreDetail moreDetail) {
		return auditTravelsMapper.addTravelsDetail(moreDetail);
	}
	
	/**
	 * @Title: updateDetailTravelsIdById
	 * @Description: 更新详情连接ID值
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午7:24:55
	 */
	public int updateDetailTravelsIdById(Integer idTravels,Integer moreId) {
		return auditTravelsMapper.updateDetailTravelsIdById(idTravels, moreId);
	}
	
	
	/**
	 * @Title: updateTravelsState
	 * @Description: 更新审核状态
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午5:22:53
	 */
	public int updateTravelsStatus(Integer auditId,Integer status,Date time) {
		return auditTravelsMapper.updateTravelsStatus(auditId, status, time);
	}
	
	/**
	 * @Title: findAuditTravelsById
	 * @Description: 根据ID值查询审核版游记
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午8:02:24
	 */
	public AuditTravels findAuditTravelsById(Integer auditId) {
		return auditTravelsMapper.findAuditTravelsById(auditId);
	}
	
	/**
	 * @Title: findNotAuditTravels
	 * @Description: 查找没有审核的auditTravels列表
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午6:28:24
	 */
	public List<AuditTravels> findAllNotAuditTravels(){
		return auditTravelsMapper.findAllNotAuditTravels();
	}
	
	/**
	 * @Title: selectForPage
	 * @Description: 分页查询
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:09:52
	 */
	public List<AuditTravels> findForPage(int status, int startIndex,int pageSize){
		return auditTravelsMapper.findForPage(status,startIndex, pageSize);
	}
	
	/**
	 * @Title: findTopicCount
	 * @Description: 查询总数量
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:12:29
	 */
	public int findTravelsCount(int status) {
		return auditTravelsMapper.findTravelsCount(status);
	}
}
