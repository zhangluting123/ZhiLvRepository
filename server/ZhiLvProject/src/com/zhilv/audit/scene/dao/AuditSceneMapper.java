package com.zhilv.audit.scene.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.AuditMessage;
import com.zhilv.entity.AuditScene;

/**   
 * @ClassName: AuditSceneMapper   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年2月8日 上午10:16:43       
 */
public interface AuditSceneMapper {
	
	/**
	 * @Title: addAuditScene
	 * @Description: 添加审核版景点
	 * @author: 张璐婷 
	 * @date: 2021年2月8日 上午10:17:22
	 */
	public int addAuditScene(@Param("audit")AuditScene auditScene);

	/**
	 * @Title: updateSceneStatus
	 * @Description: 更新景点状态
	 * @author: 张璐婷 
	 * @date: 2021年2月8日 上午10:17:52
	 */
	public int updateSceneStatus(@Param("auditId")Integer auditId, @Param("status")Integer status, @Param("time")Date time);
	
	/**
	 * @Title: findForPage
	 * @Description: 分页查询
	 * @author: 张璐婷 
	 * @date: 2021年2月8日 上午10:19:49
	 */
	public List<AuditScene> findForPage(int startIndex,int pageSize);
	
	/**
	 * @Title: findSceneCount
	 * @Description: 查询景点数量未审核
	 * @author: 张璐婷 
	 * @date: 2021年2月8日 上午10:20:33
	 */
	public int findSceneCount();
	
	/**
	 * @Title: findAuditSceneById
	 * @Description: 根据ID值查询景点
	 * @author: 张璐婷 
	 * @date: 2021年2月8日 上午10:29:56
	 */
	public AuditScene findAuditSceneById(Integer auditId);
	
	/**
	 * @Title: findSceneByUserId
	 * @Description: 根据用户id查询景点编辑信息
	 * @author: 张璐婷
	 * @date: 2021年3月4日 下午9:40:18
	 */
	public List<AuditMessage> findSceneByUserId(Integer userId);
}
