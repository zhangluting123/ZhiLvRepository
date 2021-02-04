package com.zhilv.travels.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.Img;
import com.zhilv.entity.MoreDetail;
import com.zhilv.entity.Travels;

/**   
 * @ClassName: TravelsMapper   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��20�� ����5:08:15       
 */
public interface TravelsMapper {
	
	/**
	 * @Title: findTravelsByTopicId
	 * @Description: ��ѯָ��������μ�
	 * @author: ����� 
	 * @date: 2021��1��31�� ����3:20:23
	 */
	public List<Travels> findTravelsByTopicId(Integer topicId);
	
	/**
	 * @Title: findTravelsFollowed
	 * @Description: ��ѯ��ע���˵��μ�
	 * @author: ����� 
	 * @date: 2021��1��31�� ����2:36:43
	 */
	public List<Travels> findTravelsFollowed(Integer userId);
	
	/**
	 * @Title: findTravelsByUserId
	 * @Description: ��ѯָ���û��μ�
	 * @author: ����� 
	 * @date: 2021��1��31�� ����1:39:34
	 */
	public List<Travels> findTravelsByUserId(Integer userId);
	
	/**
	 * @Title: findTravelsByLocation
	 * @Description: ��ѯͬ���μ�
	 * @author: ����� 
	 * @date: 2021��1��31�� ����1:34:49
	 */
	public List<Travels> findTravelsByLocation(String location);
	
	/**
	 * @Title: addAuditTravels
	 * @Description: ��ӷ������μ�
	 * @author: ����� 
	 * @date: 2021��1��20�� ����6:36:34
	 */
	public int addTravels(@Param("travels")Travels travels);
	
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
	 * @Description: ���������travel_id
	 * @author: ����� 
	 * @date: 2021��1��20�� ����8:48:59
	 */
	public int updateDetailTravelsIdById(@Param("travelsId")Integer travelsId,@Param("moreId")Integer moreId);
	
	/**
	 * @Title: updateTravelsById
	 * @Description: �����μ�
	 * @author: ����� 
	 * @date: 2021��1��20�� ����8:24:39
	 */
	public int updateTravelsById(@Param("travels")Travels travels);
	
	/**
	 * @Title: findImgByTravelsId
	 * @Description: ����travelsId����ͼƬ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����9:07:05
	 */
	public List<Img> findImgByTravelsId(@Param("travelsId")Integer travelsId);
	
	/**
	 * @Title: deleteImgById
	 * @Description: ����IDֵɾ��ָ��ͼƬ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����8:24:43
	 */
	public int deleteImgById(@Param("imgId")Integer imgId);
	
	/**
	 * @Title: updateTravelsDetail
	 * @Description: ��������
	 * @author: ����� 
	 * @date: 2021��1��20�� ����8:24:47
	 */
	public int updateTravelsDetail(@Param("detail")MoreDetail moreDetail);
	
	/**
	 * @Title: findAllTravels
	 * @Description: ��ѯ���з������μ�
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:57:52
	 */
	public List<Travels> findAllTravels();
	
	
	/**
	 * @Title: findTravelsById
	 * @Description: ����IDֵ��ѯ�μ�
	 * @author: ����� 
	 * @date: 2021��1��20�� ����5:40:58
	 */
	public Travels findTravelsById(@Param("travelsId")Integer travelsId);
	
	/**
	 * @Title: deleteTravelsById
	 * @Description: ����IDֵɾ���μ�
	 * @author: ����� 
	 * @date: 2021��1��22�� ����6:16:45
	 */
	public int deleteTravelsById(@Param("travelsId")Integer travelsId);
	
	/**
	 * @Title: deleteDetailByTravelsId
	 * @Description: ɾ����ϸ��Ϣ
	 * @author: ����� 
	 * @date: 2021��1��26�� ����11:37:16
	 */
	public int deleteDetailByTravelsId(@Param("travelsId")Integer travelsId);
	
	/**
	 * @Title: deleteImgByTravelsId
	 * @Description: ɾ��ͼƬ
	 * @author: ����� 
	 * @date: 2021��1��26�� ����11:37:12
	 */
	public int deleteImgByTravelsId(@Param("travelsId")Integer travelsId);
	
}

