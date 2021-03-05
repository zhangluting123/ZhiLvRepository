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
 * @author: �����
 * @date: 2021��1��25�� ����11:27:10       
 */
@Service
public class AuditVideoService {
	
	@Resource
	private AuditVideoMapper auditVideoMapper;
	
	/**
	 * @Title: addAuditVideo
	 * @Description: �����˰���Ƶ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����6:36:34
	 */
	public int addAuditVideo(AuditVideo auditVideo) {
		return auditVideoMapper.addAuditVideo(auditVideo);
	}
	
	
	/**
	 * @Title: addVideoDetail
	 * @Description: �����ϸ��Ϣ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����7:04:58
	 */
	public int addVideoDetail(MoreDetail moreDetail) {
		return auditVideoMapper.addVideoDetail(moreDetail);
	}
	
	/**
	 * @Title: updateDetailVideoIdById
	 * @Description: ������������IDֵ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����7:24:55
	 */
	public int updateDetailVideoIdById(Integer idVideo,Integer moreId) {
		return auditVideoMapper.updateDetailVideoIdById(idVideo, moreId);
	}
	
	
	/**
	 * @Title: updateVideoStatus
	 * @Description: �������״̬
	 * @author: ����� 
	 * @date: 2021��1��19�� ����5:22:53
	 */
	public int updateVideoStatus(Integer auditId,Integer status,Date time) {
		return auditVideoMapper.updateVideoStatus(auditId, status, time);
	}
	
	/**
	 * @Title: findAuditVideoById
	 * @Description: ����IDֵ��ѯ��˰���Ƶ
	 * @author: ����� 
	 * @date: 2021��1��19�� ����8:02:24
	 */
	public AuditVideo findAuditVideoById(Integer auditId) {
		return auditVideoMapper.findAuditVideoById(auditId);
	}
	
	/**
	 * @Title: findNotAuditVideo
	 * @Description: ����û����˵�auditVideo�б�
	 * @author: ����� 
	 * @date: 2021��1��19�� ����6:28:24
	 */
	public List<AuditVideo> findAllNotAuditVideo(){
		return auditVideoMapper.findAllNotAuditVideo();
	}
	
	/**
	 * @Title: selectForPage
	 * @Description: ��ҳ��ѯ
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:09:52
	 */
	public List<AuditVideo> findForPage(int status,int startIndex,int pageSize){
		return auditVideoMapper.findForPage(status,startIndex, pageSize);
	}
	
	/**
	 * @Title: findVideoCount
	 * @Description: ��ѯ������
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:12:29
	 */
	public int findVideoCount(int status) {
		return auditVideoMapper.findVideoCount(status);
	}

	/**
	 * @Title: findVideoByUserId
	 * @Description: 
	 * @author: �����
	 * @date: 2021��3��4�� ����9:50:44
	 */
	public List<AuditMessage> findVideoByUserId(Integer userId){
		return auditVideoMapper.findVideoByUserId(userId);
	}
}
