package com.zhilv.audit.scene.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.AuditMessage;
import com.zhilv.entity.AuditScene;

/**   
 * @ClassName: AuditSceneMapper   
 * @Description:TODO
 * @author: �����
 * @date: 2021��2��8�� ����10:16:43       
 */
public interface AuditSceneMapper {
	
	/**
	 * @Title: addAuditScene
	 * @Description: �����˰澰��
	 * @author: ����� 
	 * @date: 2021��2��8�� ����10:17:22
	 */
	public int addAuditScene(@Param("audit")AuditScene auditScene);

	/**
	 * @Title: updateSceneStatus
	 * @Description: ���¾���״̬
	 * @author: ����� 
	 * @date: 2021��2��8�� ����10:17:52
	 */
	public int updateSceneStatus(@Param("auditId")Integer auditId, @Param("status")Integer status, @Param("time")Date time);
	
	/**
	 * @Title: findForPage
	 * @Description: ��ҳ��ѯ
	 * @author: ����� 
	 * @date: 2021��2��8�� ����10:19:49
	 */
	public List<AuditScene> findForPage(int startIndex,int pageSize);
	
	/**
	 * @Title: findSceneCount
	 * @Description: ��ѯ��������δ���
	 * @author: ����� 
	 * @date: 2021��2��8�� ����10:20:33
	 */
	public int findSceneCount();
	
	/**
	 * @Title: findAuditSceneById
	 * @Description: ����IDֵ��ѯ����
	 * @author: ����� 
	 * @date: 2021��2��8�� ����10:29:56
	 */
	public AuditScene findAuditSceneById(Integer auditId);
	
	/**
	 * @Title: findSceneByUserId
	 * @Description: �����û�id��ѯ����༭��Ϣ
	 * @author: �����
	 * @date: 2021��3��4�� ����9:40:18
	 */
	public List<AuditMessage> findSceneByUserId(Integer userId);
}
