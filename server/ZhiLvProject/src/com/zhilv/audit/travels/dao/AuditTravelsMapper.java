package com.zhilv.audit.travels.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.AuditMessage;
import com.zhilv.entity.AuditTravels;
import com.zhilv.entity.Img;
import com.zhilv.entity.MoreDetail;

/**   
 * @ClassName: AuditTravelsMapper   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月20日 下午4:55:41       
 */
public interface AuditTravelsMapper {
	
	/**
	 * @Title: addAuditTravels
	 * @Description: 添加审核版游记
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午6:36:34
	 */
	public int addAuditTravels(@Param("audit")AuditTravels auditTravels);
	
	/**
	 * @Title: addTravelsImg
	 * @Description: 添加图片
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午7:03:40
	 */
	public int addTravelsImg(@Param("imgs")List<Img> imgs);
	
	/**
	 * @Title: addTravelsDetail
	 * @Description: 添加详细信息
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午7:04:58
	 */
	public int addTravelsDetail(@Param("detail")MoreDetail moreDetail);
	
	/**
	 * @Title: updateDetailTravelsIdById
	 * @Description: 更新详情连接ID值
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午7:24:55
	 */
	public int updateDetailTravelsIdById(@Param("idTravels")Integer idTravels,@Param("moreId")Integer moreId);
	
	
	/**
	 * @Title: updateTravelsState
	 * @Description: 更新审核状态
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午5:22:53
	 */
	public int updateTravelsStatus(@Param("auditId")Integer auditId,@Param("status")Integer status,@Param("time")Date time);
	
	/**
	 * @Title: findAuditTravelsById
	 * @Description: 根据ID值查询审核版游记
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午8:02:24
	 */
	public AuditTravels findAuditTravelsById(@Param("auditId")Integer auditId);
	
	/**
	 * @Title: findNotAuditTravels
	 * @Description: 查找没有审核的auditTravels列表
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午6:28:24
	 */
	public List<AuditTravels> findAllNotAuditTravels();
	
	/**
	 * @Title: selectForPage
	 * @Description: 分页查询
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:09:52
	 */
	public List<AuditTravels> findForPage(@Param("status")int status,@Param("start")int startIndex, @Param("size")int pageSize);
	
	/**
	 * @Title: findTopicCount
	 * @Description: 查询总数量
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:12:29
	 */
	public int findTravelsCount(int status);
	
	/**
	 * @Title: findTravelsByUserId
	 * @Description: 
	 * @author: 张璐婷
	 * @date: 2021年3月4日 下午9:48:31
	 */
	public List<AuditMessage> findTravelsByUserId(Integer userId);

}
