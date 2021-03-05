package com.zhilv.audit.scene.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.audit.scene.dao.AuditSceneMapper;
import com.zhilv.entity.AuditMessage;
import com.zhilv.entity.AuditScene;

/**   
 * @ClassName: AuditSceneService   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年2月8日 上午10:21:53       
 */
@Service
public class AuditSceneService {
	
	@Resource
	private AuditSceneMapper auditSceneMapper;
	
	/**
	 * @Title: addAuditScene
	 * @Description: 添加审核版景点
	 * @author: 张璐婷 
	 * @date: 2021年2月8日 上午10:17:22
	 */
	public int addAuditScene(AuditScene auditScene) {
		return auditSceneMapper.addAuditScene(auditScene);
	}

	/**
	 * @Title: updateSceneStatus
	 * @Description: 更新景点状态
	 * @author: 张璐婷 
	 * @date: 2021年2月8日 上午10:17:52
	 */
	public int updateSceneStatus(Integer auditId, Integer status, Date time) {
		return auditSceneMapper.updateSceneStatus(auditId, status, time);
	}
	
	/**
	 * @Title: findForPage
	 * @Description: 分页查询
	 * @author: 张璐婷 
	 * @date: 2021年2月8日 上午10:19:49
	 */
	public List<AuditScene> findForPage(int startIndex,int pageSize){
		return auditSceneMapper.findForPage(startIndex, pageSize);
	}
	
	/**
	 * @Title: findSceneCount
	 * @Description: 查询景点数量未审核
	 * @author: 张璐婷 
	 * @date: 2021年2月8日 上午10:20:33
	 */
	public int findSceneCount() {
		return auditSceneMapper.findSceneCount();
	}
	
	/**
	 * @Title: findAuditSceneById
	 * @Description: 根据ID值查询景点
	 * @author: 张璐婷 
	 * @date: 2021年2月8日 上午10:29:56
	 */
	public AuditScene findAuditSceneById(Integer auditId) {
		return auditSceneMapper.findAuditSceneById(auditId);
	}
	
	/**
	 * @Title: findSceneByUserId
	 * @Description: 根据用户id查询景点编辑信息
	 * @author: 张璐婷
	 * @date: 2021年3月4日 下午9:40:18
	 */
	public List<AuditMessage> findSceneByUserId(Integer userId) {
		return auditSceneMapper.findSceneByUserId(userId);
	}

}
