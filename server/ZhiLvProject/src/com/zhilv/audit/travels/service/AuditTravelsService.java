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
 * @author: �����
 * @date: 2021��1��20�� ����4:56:16       
 */
@Service
public class AuditTravelsService {
	@Resource
	private AuditTravelsMapper auditTravelsMapper;
	
	/**
	 * @Title: addAuditTravels
	 * @Description: �����˰��μ�
	 * @author: ����� 
	 * @date: 2021��1��20�� ����6:36:34
	 */
	public int addAuditTravels(AuditTravels auditTravels) {
		return auditTravelsMapper.addAuditTravels(auditTravels);
	}
	
	/**
	 * @Title: addTravelsImg
	 * @Description: ���ͼƬ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����7:03:40
	 */
	public int addTravelsImg(List<Img> imgs) {
		return auditTravelsMapper.addTravelsImg(imgs);
	}
	
	/**
	 * @Title: addTravelsDetail
	 * @Description: �����ϸ��Ϣ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����7:04:58
	 */
	public int addTravelsDetail(MoreDetail moreDetail) {
		return auditTravelsMapper.addTravelsDetail(moreDetail);
	}
	
	/**
	 * @Title: updateDetailTravelsIdById
	 * @Description: ������������IDֵ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����7:24:55
	 */
	public int updateDetailTravelsIdById(Integer idTravels,Integer moreId) {
		return auditTravelsMapper.updateDetailTravelsIdById(idTravels, moreId);
	}
	
	
	/**
	 * @Title: updateTravelsState
	 * @Description: �������״̬
	 * @author: ����� 
	 * @date: 2021��1��19�� ����5:22:53
	 */
	public int updateTravelsStatus(Integer auditId,Integer status,Date time) {
		return auditTravelsMapper.updateTravelsStatus(auditId, status, time);
	}
	
	/**
	 * @Title: findAuditTravelsById
	 * @Description: ����IDֵ��ѯ��˰��μ�
	 * @author: ����� 
	 * @date: 2021��1��19�� ����8:02:24
	 */
	public AuditTravels findAuditTravelsById(Integer auditId) {
		return auditTravelsMapper.findAuditTravelsById(auditId);
	}
	
	/**
	 * @Title: findNotAuditTravels
	 * @Description: ����û����˵�auditTravels�б�
	 * @author: ����� 
	 * @date: 2021��1��19�� ����6:28:24
	 */
	public List<AuditTravels> findAllNotAuditTravels(){
		return auditTravelsMapper.findAllNotAuditTravels();
	}
	
	/**
	 * @Title: selectForPage
	 * @Description: ��ҳ��ѯ
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:09:52
	 */
	public List<AuditTravels> findForPage(int status, int startIndex,int pageSize){
		return auditTravelsMapper.findForPage(status,startIndex, pageSize);
	}
	
	/**
	 * @Title: findTopicCount
	 * @Description: ��ѯ������
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:12:29
	 */
	public int findTravelsCount(int status) {
		return auditTravelsMapper.findTravelsCount(status);
	}
}
