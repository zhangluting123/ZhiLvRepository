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
 * @author: 张璐婷
 * @date: 2021年2月10日 下午3:03:11
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
			System.out.println("添加一条浏览记录");
		}else {
			System.out.println("浏览记录添加失败");
		}
	}
}
