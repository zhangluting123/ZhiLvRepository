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
 * @author: 张璐婷
 * @date: 2021年1月19日 下午5:19:20       
 */
@Service
public class AuditTopicService {
	
	@Resource
	private AuditTopicMapper auditTopicMapper;

	/**
	 * @Title: addTopic
	 * @Description: 添加审核版话题
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午5:20:19
	 */
	public int addAuditTopic(Topic topic) {
		return auditTopicMapper.addAuditTopic(topic);
	}
	
	
	/**
	 * @Title: updateTopicState
	 * @Description: 更新审核状态
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午5:22:53
	 */
	public int updateTopicStatus(Integer auditId,Integer status,Date time) {
		return auditTopicMapper.updateTopicStatus(auditId, status, time);
	}
	
	/**
	 * @Title: findAuditTopicById
	 * @Description: 根据ID值查询审核版话题
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午8:02:24
	 */
	public AuditTopic findAuditTopicById(Integer auditId) {
		return auditTopicMapper.findAuditTopicById(auditId);
	}
	
	/**
	 * @Title: findNotAuditTopic
	 * @Description: 查找没有审核的auditTopic列表
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午6:28:24
	 */
	public List<AuditTopic> findAllNotAuditTopic(){
		return auditTopicMapper.findAllNotAuditTopic();
	}
	
	/**
	 * @Title: selectForPage
	 * @Description: 分页查询
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:09:52
	 */
	public List<AuditTopic> findForPage(int startIndex,int pageSize){
		return auditTopicMapper.findForPage(startIndex, pageSize);
	}
	
	/**
	 * @Title: findTopicCount
	 * @Description: 查询总数量
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:12:29
	 */
	public int findTopicCount() {
		return auditTopicMapper.findTopicCount();
	}
}
