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
 * @author: �����
 * @date: 2021��1��25�� ����11:21:12       
 */
public interface AuditVideoMapper {
	
	/**
	 * @Title: addAuditVideo
	 * @Description: �����˰���Ƶ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����6:36:34
	 */
	public int addAuditVideo(@Param("audit")AuditVideo auditVideo);
	
	
	/**
	 * @Title: addVideoDetail
	 * @Description: �����ϸ��Ϣ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����7:04:58
	 */
	public int addVideoDetail(@Param("detail")MoreDetail moreDetail);
	
	/**
	 * @Title: updateDetailVideoIdById
	 * @Description: ������������IDֵ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����7:24:55
	 */
	public int updateDetailVideoIdById(@Param("idVideo")Integer idVideo,@Param("moreId")Integer moreId);
	
	
	/**
	 * @Title: updateVideoState
	 * @Description: �������״̬
	 * @author: ����� 
	 * @date: 2021��1��19�� ����5:22:53
	 */
	public int updateVideoStatus(@Param("auditId")Integer auditId,@Param("status")Integer status,@Param("time")Date time);
	
	/**
	 * @Title: findAuditVideoById
	 * @Description: ����IDֵ��ѯ��˰���Ƶ
	 * @author: ����� 
	 * @date: 2021��1��19�� ����8:02:24
	 */
	public AuditVideo findAuditVideoById(@Param("auditId")Integer auditId);
	
	/**
	 * @Title: findNotAuditVideo
	 * @Description: ����û����˵�auditVideo�б�
	 * @author: ����� 
	 * @date: 2021��1��19�� ����6:28:24
	 */
	public List<AuditVideo> findAllNotAuditVideo();
	
	/**
	 * @Title: selectForPage
	 * @Description: ��ҳ��ѯ
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:09:52
	 */
	public List<AuditVideo> findForPage(@Param("status")int status,@Param("start")int startIndex, @Param("size")int pageSize);
	
	/**
	 * @Title: findVideoCount
	 * @Description: ��ѯ������
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:12:29
	 */
	public int findVideoCount(int status);
	
	/**
	 * @Title: findVideoByUserId
	 * @Description: 
	 * @author: �����
	 * @date: 2021��3��4�� ����9:50:44
	 */
	public List<AuditMessage> findVideoByUserId(Integer userId);
}
