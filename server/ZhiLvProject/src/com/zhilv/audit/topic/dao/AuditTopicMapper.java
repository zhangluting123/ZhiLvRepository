package com.zhilv.audit.topic.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.AuditTopic;
import com.zhilv.entity.Topic;

/**   
 * @ClassName: AuditTopicMapper   
 * @Description:��˻���
 * @author: �����
 * @date: 2021��1��19�� ����5:18:39       
 */
public interface AuditTopicMapper {
	
	/**
	 * @Title: addTopic
	 * @Description: �����˰滰��
	 * @author: ����� 
	 * @date: 2021��1��19�� ����5:20:19
	 */
	public int addAuditTopic(@Param("topic")Topic topic);
	
	
	/**
	 * @Title: updateTopicState
	 * @Description: �������״̬
	 * @author: ����� 
	 * @date: 2021��1��19�� ����5:22:53
	 */
	public int updateTopicStatus(@Param("auditId")Integer auditId,@Param("status")Integer status,@Param("time")Date time);
	
	/**
	 * @Title: findAuditTopicById
	 * @Description: ����IDֵ��ѯ��˰滰��
	 * @author: ����� 
	 * @date: 2021��1��19�� ����8:02:24
	 */
	public AuditTopic findAuditTopicById(@Param("auditId")Integer auditId);
	
	/**
	 * @Title: findNotAuditTopic
	 * @Description: ����û����˵�auditTopic�б�
	 * @author: ����� 
	 * @date: 2021��1��19�� ����6:28:24
	 */
	public List<AuditTopic> findAllNotAuditTopic();
	
	/**
	 * @Title: selectForPage
	 * @Description: ��ҳ��ѯ
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:09:52
	 */
	public List<AuditTopic> findForPage(int startIndex,int pageSize);
	
	/**
	 * @Title: findTopicCount
	 * @Description: ��ѯ������
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:12:29
	 */
	public int findTopicCount();
	
}
