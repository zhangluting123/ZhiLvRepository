package com.zhilv.audit.topic.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.AuditMessage;
import com.zhilv.entity.AuditTopic;
import com.zhilv.entity.Topic;

/**   
 * @ClassName: AuditTopicMapper   
 * @Description:审核话题
 * @author: 张璐婷
 * @date: 2021年1月19日 下午5:18:39       
 */
public interface AuditTopicMapper {
	
	/**
	 * @Title: addTopic
	 * @Description: 添加审核版话题
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午5:20:19
	 */
	public int addAuditTopic(@Param("topic")Topic topic);
	
	
	/**
	 * @Title: updateTopicState
	 * @Description: 更新审核状态
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午5:22:53
	 */
	public int updateTopicStatus(@Param("auditId")Integer auditId,@Param("status")Integer status,@Param("time")Date time);
	
	/**
	 * @Title: findAuditTopicById
	 * @Description: 根据ID值查询审核版话题
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午8:02:24
	 */
	public AuditTopic findAuditTopicById(@Param("auditId")Integer auditId);
	
	/**
	 * @Title: findNotAuditTopic
	 * @Description: 查找没有审核的auditTopic列表
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午6:28:24
	 */
	public List<AuditTopic> findAllNotAuditTopic();
	
	/**
	 * @Title: selectForPage
	 * @Description: 分页查询
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:09:52
	 */
	public List<AuditTopic> findForPage(@Param("status")int status,@Param("start")int startIndex, @Param("size")int pageSize);
	
	/**
	 * @Title: findTopicCount
	 * @Description: 查询总数量
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:12:29
	 */
	public int findTopicCount(int status);
	
	/**
	 * @Title: findTopicByUserId
	 * @Description: 查询某用户创建话题
	 * @author: 张璐婷
	 * @date: 2021年3月4日 下午9:35:26
	 */
	public List<AuditMessage> findTopicByUserId(Integer userId);
	
}
