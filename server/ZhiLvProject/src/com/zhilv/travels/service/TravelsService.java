package com.zhilv.travels.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.Img;
import com.zhilv.entity.MoreDetail;
import com.zhilv.entity.Travels;
import com.zhilv.travels.dao.TravelsMapper;

/**   
 * @ClassName: TravelsService   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��20�� ����5:08:38       
 */
@Service
public class TravelsService {
	
	@Resource
	private TravelsMapper travelsMapper;
	
	/**
	 * @Title: findTravelsByTopicId
	 * @Description: ��ѯָ��������μ�
	 * @author: ����� 
	 * @date: 2021��1��31�� ����3:20:23
	 */
	public List<Travels> findTravelsByTopicId(Integer topicId){
		return travelsMapper.findTravelsByTopicId(topicId);
	}
	
	/**
	 * @Title: findTravelsFollowed
	 * @Description: ��ѯ��ע���˵��μ�
	 * @author: ����� 
	 * @date: 2021��1��31�� ����2:36:43
	 */
	public List<Travels> findTravelsFollowed(Integer userId){
		return travelsMapper.findTravelsFollowed(userId);
	}
	
	/**
	 * @Title: findTravelsByUserId
	 * @Description: ��ѯָ���û��μ�
	 * @author: ����� 
	 * @date: 2021��1��31�� ����1:39:34
	 */
	public List<Travels> findTravelsByUserId(Integer userId){
		return travelsMapper.findTravelsByUserId(userId);
	}
	
	/**
	 * @Title: findTravelsByLocation
	 * @Description: ��ѯͬ���μ�
	 * @author: ����� 
	 * @date: 2021��1��31�� ����1:34:49
	 */
	public List<Travels> findTravelsByLocation(String location){
		return travelsMapper.findTravelsByLocation(location);
	}
	
	/**
	 * @Title: addAuditTravels
	 * @Description: ��ӷ������μ�
	 * @author: ����� 
	 * @date: 2021��1��20�� ����6:36:34
	 */
	public int addTravels(Travels travels) {
		return travelsMapper.addTravels(travels);
	}
	
	/**
	 * @Title: addTravelsImg
	 * @Description: ���ͼƬ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����7:03:40
	 */
	public int addTravelsImg(List<Img> imgs) {
		return travelsMapper.addTravelsImg(imgs);
	}
	
	/**
	 * @Title: addTravelsDetail
	 * @Description: �����ϸ��Ϣ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����7:04:58
	 */
	public int addTravelsDetail(MoreDetail moreDetail) {
		return travelsMapper.addTravelsDetail(moreDetail);
	}
	
	/**
	 * @Title: updateDetailTravelsIdById
	 * @Description: ���������travel_id
	 * @author: ����� 
	 * @date: 2021��1��20�� ����8:48:59
	 */
	public int updateDetailTravelsIdById(Integer travelsId,Integer moreId) {
		return travelsMapper.updateDetailTravelsIdById(travelsId, moreId);
	}
	
	/**
	 * @Title: updateTravelsById
	 * @Description: �����μ�
	 * @author: ����� 
	 * @date: 2021��1��20�� ����8:24:39
	 */
	public int updateTravelsById(Travels travels) {
		return travelsMapper.updateTravelsById(travels);
	}
	
	/**
	 * @Title: findImgByTravelsId
	 * @Description: ����travelsId����ͼƬ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����9:07:05
	 */
	public List<Img> findImgByTravelsId(Integer travelsId){
		return travelsMapper.findImgByTravelsId(travelsId);
	}
	
	/**
	 * @Title: deleteImgById
	 * @Description: ����IDֵɾ��ָ��ͼƬ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����8:24:43
	 */
	public int deleteImgById(Integer imgId) {
		return travelsMapper.deleteImgById(imgId);
	}
	
	/**
	 * @Title: updateTravelsDetail
	 * @Description: ��������
	 * @author: ����� 
	 * @date: 2021��1��20�� ����8:24:47
	 */
	public int updateTravelsDetail(MoreDetail moreDetail) {
		return travelsMapper.updateTravelsDetail(moreDetail);
	}
	
	/**
	 * @Title: findAllTravels
	 * @Description: ��ѯ���з������μ�
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:57:52
	 */
	public List<Travels> findAllTravels(){
		return travelsMapper.findAllTravels();
	}

	/**
	 * @Title: findTravelsById
	 * @Description: ����IDֵ��ѯ�μ�
	 * @author: ����� 
	 * @date: 2021��1��20�� ����5:40:58
	 */
	public Travels findTravelsById(Integer travelsId) {
		return travelsMapper.findTravelsById(travelsId);
	}

	/**
	 * @Title: deleteTravelsById
	 * @Description: ����IDֵɾ���μ�
	 * @author: ����� 
	 * @date: 2021��1��22�� ����6:16:45
	 */
	public int deleteTravelsById(Integer travelsId) {
		return travelsMapper.deleteTravelsById(travelsId);
	}
	
	/**
	 * @Title: deleteDetailByTravelsId
	 * @Description: ɾ����ϸ��Ϣ
	 * @author: ����� 
	 * @date: 2021��1��26�� ����11:37:16
	 */
	public int deleteDetailByTravelsId(Integer travelsId) {
		return travelsMapper.deleteDetailByTravelsId(travelsId);
	}
	
	/**
	 * @Title: deleteImgByTravelsId
	 * @Description: ɾ��ͼƬ
	 * @author: ����� 
	 * @date: 2021��1��26�� ����11:37:12
	 */
	public int deleteImgByTravelsId(Integer travelsId) {
		return travelsMapper.deleteImgByTravelsId(travelsId);
	}
}
