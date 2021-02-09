package com.zhilv.audit.scene.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.audit.scene.dao.AuditSceneMapper;
import com.zhilv.entity.AuditScene;

/**   
 * @ClassName: AuditSceneService   
 * @Description:TODO
 * @author: �����
 * @date: 2021��2��8�� ����10:21:53       
 */
@Service
public class AuditSceneService {
	
	@Resource
	private AuditSceneMapper auditSceneMapper;
	
	/**
	 * @Title: addAuditScene
	 * @Description: �����˰澰��
	 * @author: ����� 
	 * @date: 2021��2��8�� ����10:17:22
	 */
	public int addAuditScene(AuditScene auditScene) {
		return auditSceneMapper.addAuditScene(auditScene);
	}

	/**
	 * @Title: updateSceneStatus
	 * @Description: ���¾���״̬
	 * @author: ����� 
	 * @date: 2021��2��8�� ����10:17:52
	 */
	public int updateSceneStatus(Integer auditId, Integer status, Date time) {
		return auditSceneMapper.updateSceneStatus(auditId, status, time);
	}
	
	/**
	 * @Title: findForPage
	 * @Description: ��ҳ��ѯ
	 * @author: ����� 
	 * @date: 2021��2��8�� ����10:19:49
	 */
	public List<AuditScene> findForPage(int startIndex,int pageSize){
		return auditSceneMapper.findForPage(startIndex, pageSize);
	}
	
	/**
	 * @Title: findSceneCount
	 * @Description: ��ѯ��������δ���
	 * @author: ����� 
	 * @date: 2021��2��8�� ����10:20:33
	 */
	public int findSceneCount() {
		return auditSceneMapper.findSceneCount();
	}
	
	/**
	 * @Title: findAuditSceneById
	 * @Description: ����IDֵ��ѯ����
	 * @author: ����� 
	 * @date: 2021��2��8�� ����10:29:56
	 */
	public AuditScene findAuditSceneById(Integer auditId) {
		return auditSceneMapper.findAuditSceneById(auditId);
	}

}
