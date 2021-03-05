package com.zhilv.audit.video.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.AuditMessage;
import com.zhilv.entity.AuditVideo;
import com.zhilv.entity.MoreDetail;

/**   
 * @ClassName: VideoMapper   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月25日 上午11:21:12       
 */
public interface AuditVideoMapper {
	
	/**
	 * @Title: addAuditVideo
	 * @Description: 添加审核版视频
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午6:36:34
	 */
	public int addAuditVideo(@Param("audit")AuditVideo auditVideo);
	
	
	/**
	 * @Title: addVideoDetail
	 * @Description: 添加详细信息
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午7:04:58
	 */
	public int addVideoDetail(@Param("detail")MoreDetail moreDetail);
	
	/**
	 * @Title: updateDetailVideoIdById
	 * @Description: 更新详情连接ID值
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午7:24:55
	 */
	public int updateDetailVideoIdById(@Param("idVideo")Integer idVideo,@Param("moreId")Integer moreId);
	
	
	/**
	 * @Title: updateVideoState
	 * @Description: 更新审核状态
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午5:22:53
	 */
	public int updateVideoStatus(@Param("auditId")Integer auditId,@Param("status")Integer status,@Param("time")Date time);
	
	/**
	 * @Title: findAuditVideoById
	 * @Description: 根据ID值查询审核版视频
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午8:02:24
	 */
	public AuditVideo findAuditVideoById(@Param("auditId")Integer auditId);
	
	/**
	 * @Title: findNotAuditVideo
	 * @Description: 查找没有审核的auditVideo列表
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午6:28:24
	 */
	public List<AuditVideo> findAllNotAuditVideo();
	
	/**
	 * @Title: selectForPage
	 * @Description: 分页查询
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:09:52
	 */
	public List<AuditVideo> findForPage(@Param("status")int status,@Param("start")int startIndex, @Param("size")int pageSize);
	
	/**
	 * @Title: findVideoCount
	 * @Description: 查询总数量
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:12:29
	 */
	public int findVideoCount(int status);
	
	/**
	 * @Title: findVideoByUserId
	 * @Description: 
	 * @author: 张璐婷
	 * @date: 2021年3月4日 下午9:50:44
	 */
	public List<AuditMessage> findVideoByUserId(Integer userId);
}
