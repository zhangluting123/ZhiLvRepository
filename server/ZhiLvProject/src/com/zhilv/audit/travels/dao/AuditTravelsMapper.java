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
 * @author: �����
 * @date: 2021��1��20�� ����4:55:41       
 */
public interface AuditTravelsMapper {
	
	/**
	 * @Title: addAuditTravels
	 * @Description: �����˰��μ�
	 * @author: ����� 
	 * @date: 2021��1��20�� ����6:36:34
	 */
	public int addAuditTravels(@Param("audit")AuditTravels auditTravels);
	
	/**
	 * @Title: addTravelsImg
	 * @Description: ���ͼƬ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����7:03:40
	 */
	public int addTravelsImg(@Param("imgs")List<Img> imgs);
	
	/**
	 * @Title: addTravelsDetail
	 * @Description: �����ϸ��Ϣ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����7:04:58
	 */
	public int addTravelsDetail(@Param("detail")MoreDetail moreDetail);
	
	/**
	 * @Title: updateDetailTravelsIdById
	 * @Description: ������������IDֵ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����7:24:55
	 */
	public int updateDetailTravelsIdById(@Param("idTravels")Integer idTravels,@Param("moreId")Integer moreId);
	
	
	/**
	 * @Title: updateTravelsState
	 * @Description: �������״̬
	 * @author: ����� 
	 * @date: 2021��1��19�� ����5:22:53
	 */
	public int updateTravelsStatus(@Param("auditId")Integer auditId,@Param("status")Integer status,@Param("time")Date time);
	
	/**
	 * @Title: findAuditTravelsById
	 * @Description: ����IDֵ��ѯ��˰��μ�
	 * @author: ����� 
	 * @date: 2021��1��19�� ����8:02:24
	 */
	public AuditTravels findAuditTravelsById(@Param("auditId")Integer auditId);
	
	/**
	 * @Title: findNotAuditTravels
	 * @Description: ����û����˵�auditTravels�б�
	 * @author: ����� 
	 * @date: 2021��1��19�� ����6:28:24
	 */
	public List<AuditTravels> findAllNotAuditTravels();
	
	/**
	 * @Title: selectForPage
	 * @Description: ��ҳ��ѯ
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:09:52
	 */
	public List<AuditTravels> findForPage(@Param("status")int status,@Param("start")int startIndex, @Param("size")int pageSize);
	
	/**
	 * @Title: findTopicCount
	 * @Description: ��ѯ������
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:12:29
	 */
	public int findTravelsCount(int status);
	
	/**
	 * @Title: findTravelsByUserId
	 * @Description: 
	 * @author: �����
	 * @date: 2021��3��4�� ����9:48:31
	 */
	public List<AuditMessage> findTravelsByUserId(Integer userId);

}
