package com.zhilv.views.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.views.dao.ViewsMapper;

/**
 * @ClassName: ViewsService   
 * @Description:
 * @author: 张璐婷
 * @date: 2021年2月10日 下午3:03:29
 */
@Service
public class ViewsService {

	@Resource
	private ViewsMapper viewsMapper;
	
	/**
	 * @Title: addViews
	 * @Description: 添加浏览记录
	 * @author: 张璐婷
	 * @date: 2021年2月10日 下午3:21:30
	 */
	public int addViews(Integer userId, Date time, Integer travelsId, Integer videoId, Integer sceneId) {
		return viewsMapper.addViews(userId, time, travelsId, videoId, sceneId);
	}
}
