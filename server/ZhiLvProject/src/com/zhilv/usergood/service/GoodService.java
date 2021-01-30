package com.zhilv.usergood.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.UserGood;
import com.zhilv.usergood.dao.GoodMapper;

/**   
 * @ClassName: GoodService   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��30�� ����11:15:18       
 */
@Service
public class GoodService {
	
	@Resource
	private GoodMapper goodMapper;
	
	/**
	 * @Title: findAllGood
	 * @Description: ����IDֵ��ѯ�û����еĵ��޼�¼
	 * @author: ����� 
	 * @date: 2021��1��30�� ����11:21:29
	 */
	public List<UserGood> findAllGood(Integer userId){
		return goodMapper.findAllGood(userId);
	}
	
	/**
	 * @Title: findIfGood
	 * @Description: ��ѯ�Ƿ����
	 * @author: ����� 
	 * @date: 2021��1��30�� ����1:08:07
	 */
	public int findIfGood(Integer userId,Integer travelsId,Integer videoId) {
		return goodMapper.findIfGood(userId, travelsId, videoId);
	}
	
	/**
	 * @Title: addGood
	 * @Description: ��ӵ��޼�¼
	 * @author: ����� 
	 * @date: 2021��1��30�� ����11:23:40
	 */
	public int addGood(Integer userId, Integer travelsId, Integer videoId,Date time) {
		return goodMapper.addGood(userId, travelsId, videoId, time);
	}
	
	/**
	 * @Title: deleteGood
	 * @Description: ȡ������
	 * @author: ����� 
	 * @date: 2021��1��30�� ����11:24:10
	 */
	public int deleteGood(Integer userId,Integer travelsId,Integer videoId) {
		return goodMapper.deleteGood(userId, travelsId, videoId);
	}
	
	/**
	 * @Title: findPraised
	 * @Description: ��ѯ�������
	 * @author: ����� 
	 * @date: 2021��1��30�� ����3:50:13
	 */
	public List<UserGood> findPraised(Integer userId){
		return goodMapper.findPraised(userId);
	}

}
