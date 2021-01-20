package com.zhilv.audit.topic.service;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.zhilv.audit.topic.dao.AuditTopicMapper;
import com.zhilv.entity.AuditTopic;
import com.zhilv.entity.Topic;

/**   
 * @ClassName: AuditTopicService   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��19�� ����5:19:20       
 */
@Service
public class AuditTopicService {
	
	@Resource
	private AuditTopicMapper auditTopicMapper;

	/**
	 * @Title: addTopic
	 * @Description: �����˰滰��
	 * @author: ����� 
	 * @date: 2021��1��19�� ����5:20:19
	 */
	public int addAuditTopic(Topic topic) {
		return auditTopicMapper.addAuditTopic(topic);
	}
	
	
	/**
	 * @Title: updateTopicState
	 * @Description: �������״̬
	 * @author: ����� 
	 * @date: 2021��1��19�� ����5:22:53
	 */
	public int updateTopicStatus(Integer auditId,Integer status,Date time) {
		return auditTopicMapper.updateTopicStatus(auditId, status, time);
	}
	
	/**
	 * @Title: findAuditTopicById
	 * @Description: ����IDֵ��ѯ��˰滰��
	 * @author: ����� 
	 * @date: 2021��1��19�� ����8:02:24
	 */
	public AuditTopic findAuditTopicById(Integer auditId) {
		return auditTopicMapper.findAuditTopicById(auditId);
	}
	
	/**
	 * @Title: findNotAuditTopic
	 * @Description: ����û����˵�auditTopic�б�
	 * @author: ����� 
	 * @date: 2021��1��19�� ����6:28:24
	 */
	public List<AuditTopic> findAllNotAuditTopic(){
		return auditTopicMapper.findAllNotAuditTopic();
	}
	
	/**
	 * @Title: selectForPage
	 * @Description: ��ҳ��ѯ
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:09:52
	 */
	public List<AuditTopic> findForPage(int startIndex,int pageSize){
		return auditTopicMapper.findForPage(startIndex, pageSize);
	}
	
	/**
	 * @Title: findTopicCount
	 * @Description: ��ѯ������
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:12:29
	 */
	public int findTopicCount() {
		return auditTopicMapper.findTopicCount();
	}
}
