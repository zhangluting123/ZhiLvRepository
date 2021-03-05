package com.zhilv.audit.video.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.audit.video.dao.AuditVideoMapper;
import com.zhilv.entity.AuditMessage;
import com.zhilv.entity.AuditVideo;
import com.zhilv.entity.MoreDetail;

/**   
 * @ClassName: VideoService   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月25日 上午11:27:10       
 */
@Service
public class AuditVideoService {
	
	@Resource
	private AuditVideoMapper auditVideoMapper;
	
	/**
	 * @Title: addAuditVideo
	 * @Description: 添加审核版视频
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午6:36:34
	 */
	public int addAuditVideo(AuditVideo auditVideo) {
		return auditVideoMapper.addAuditVideo(auditVideo);
	}
	
	
	/**
	 * @Title: addVideoDetail
	 * @Description: 添加详细信息
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午7:04:58
	 */
	public int addVideoDetail(MoreDetail moreDetail) {
		return auditVideoMapper.addVideoDetail(moreDetail);
	}
	
	/**
	 * @Title: updateDetailVideoIdById
	 * @Description: 更新详情连接ID值
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午7:24:55
	 */
	public int updateDetailVideoIdById(Integer idVideo,Integer moreId) {
		return auditVideoMapper.updateDetailVideoIdById(idVideo, moreId);
	}
	
	
	/**
	 * @Title: updateVideoStatus
	 * @Description: 更新审核状态
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午5:22:53
	 */
	public int updateVideoStatus(Integer auditId,Integer status,Date time) {
		return auditVideoMapper.updateVideoStatus(auditId, status, time);
	}
	
	/**
	 * @Title: findAuditVideoById
	 * @Description: 根据ID值查询审核版视频
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午8:02:24
	 */
	public AuditVideo findAuditVideoById(Integer auditId) {
		return auditVideoMapper.findAuditVideoById(auditId);
	}
	
	/**
	 * @Title: findNotAuditVideo
	 * @Description: 查找没有审核的auditVideo列表
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午6:28:24
	 */
	public List<AuditVideo> findAllNotAuditVideo(){
		return auditVideoMapper.findAllNotAuditVideo();
	}
	
	/**
	 * @Title: selectForPage
	 * @Description: 分页查询
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:09:52
	 */
	public List<AuditVideo> findForPage(int status,int startIndex,int pageSize){
		return auditVideoMapper.findForPage(status,startIndex, pageSize);
	}
	
	/**
	 * @Title: findVideoCount
	 * @Description: 查询总数量
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:12:29
	 */
	public int findVideoCount(int status) {
		return auditVideoMapper.findVideoCount(status);
	}

	/**
	 * @Title: findVideoByUserId
	 * @Description: 
	 * @author: 张璐婷
	 * @date: 2021年3月4日 下午9:50:44
	 */
	public List<AuditMessage> findVideoByUserId(Integer userId){
		return auditVideoMapper.findVideoByUserId(userId);
	}
}
