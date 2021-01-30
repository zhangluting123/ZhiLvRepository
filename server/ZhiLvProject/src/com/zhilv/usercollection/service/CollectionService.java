package com.zhilv.usercollection.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.UserCollection;
import com.zhilv.usercollection.dao.CollectionMapper;

/**   
 * @ClassName: CollectionService   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��30�� ����11:32:56       
 */
@Service
public class CollectionService {
	
	@Resource
	private CollectionMapper collectionMapper;
	
	/**
	 * @Title: findAllCollection
	 * @Description: ��ѯ�����ղ�
	 * @author: ����� 
	 * @date: 2021��1��30�� ����11:31:15
	 */
	public List<UserCollection> findAllCollection(Integer userId){
		return collectionMapper.findAllCollection(userId);
	}
	
	/**
	 * @Title: findIfCollect
	 * @Description: ��ѯ�Ƿ��ղ�
	 * @author: ����� 
	 * @date: 2021��1��30�� ����1:13:12
	 */
	public int findIfCollect(Integer userId, Integer travelsId, Integer videoId) {
		return collectionMapper.findIfCollect(userId, travelsId, videoId);
	}
	
	/**
	 * @Title: addCollection
	 * @Description: ����ղ�
	 * @author: ����� 
	 * @date: 2021��1��30�� ����11:31:38
	 */
	public int addCollection(Integer userId, Integer travelsId, Integer videoId, Date time) {
		return collectionMapper.addCollection(userId, travelsId, videoId, time);
	}
	
	/**
	 * @Title: deleteCollection
	 * @Description: ȡ���ղ�
	 * @author: ����� 
	 * @date: 2021��1��30�� ����11:32:05
	 */
	public int deleteCollection(Integer userId,Integer travelsId,Integer videoId) {
		return collectionMapper.deleteCollection(userId, travelsId, videoId);
	}

}
