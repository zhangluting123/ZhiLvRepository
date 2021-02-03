package com.zhilv.video.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhilv.video.service.VideoService;

/**   
 * @ClassName: VideoController   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月25日 下午2:45:19       
 */
@RestController
@RequestMapping("/video")
public class VideoController {
	
	@Resource
	private VideoService videoService;
	
	@RequestMapping(value="/delete",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String delete(@RequestParam("videoId")Integer videoId) {
		int i = videoService.deleteVideoById(videoId);
		videoService.deleteDetailByVideoId(videoId);
		if(i > 0) {
			System.out.println("视频删除成功");
			return "OK";
		}else {
			System.out.println("视频删除失败");
			return "ERROR";
		}
	}


}
