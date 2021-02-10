package com.zhilv.views.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.views.dao.ViewsMapper;

/**
 * @ClassName: ViewsService   
 * @Description:
 * @author: �����
 * @date: 2021��2��10�� ����3:03:29
 */
@Service
public class ViewsService {

	@Resource
	private ViewsMapper viewsMapper;
	
	/**
	 * @Title: addViews
	 * @Description: ��������¼
	 * @author: �����
	 * @date: 2021��2��10�� ����3:21:30
	 */
	public int addViews(Integer userId, Date time, Integer travelsId, Integer videoId, Integer sceneId) {
		return viewsMapper.addViews(userId, time, travelsId, videoId, sceneId);
	}
}
