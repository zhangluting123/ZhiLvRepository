package com.zhilv.views.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhilv.util.DateUtil;
import com.zhilv.views.service.ViewsService;

/**
 * @ClassName: ViewsController   
 * @Description:
 * @author: �����
 * @date: 2021��2��10�� ����3:03:11
 */
@RestController
@RequestMapping("/views")
public class ViewsController {

	@Resource
	private ViewsService viewsService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public void add(@RequestParam(value="userId",required=true)Integer userId,
			@RequestParam(value="videoId",required=false)Integer videoId,
			@RequestParam(value="travelsId",required=false)Integer travelsId,
			@RequestParam(value="sceneId",required=false)Integer sceneId) {
		int i = viewsService.addViews(userId, DateUtil.getCurrentTimes(), travelsId, videoId, sceneId);
		if(i > 0) {
			System.out.println("���һ�������¼");
		}else {
			System.out.println("�����¼���ʧ��");
		}
	}
}
