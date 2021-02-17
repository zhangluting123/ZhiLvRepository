package com.zhilv.views.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhilv.entity.MoreDetail;
import com.zhilv.entity.Scene;
import com.zhilv.entity.UserInterest;
import com.zhilv.recommend.scene.service.SceneService;
import com.zhilv.userInterest.service.UserInterestService;
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
	@Resource
	private UserInterestService UserInterestService;
	@Resource
	private SceneService sceneService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public void add(@RequestParam(value="userId",required=true)Integer userId,
			@RequestParam(value="videoId",required=false)Integer videoId,
			@RequestParam(value="travelsId",required=false)Integer travelsId,
			@RequestParam(value="sceneId",required=false)Integer sceneId) {
		int i = viewsService.addViews(userId, DateUtil.getCurrentTimes(), travelsId, videoId, sceneId);
		if(i > 0) {
			int labelId = -1;
			if(null != travelsId || null != videoId) { //浏览的是游记或视频
				MoreDetail moreDetail = UserInterestService.findMoreDetailByTidOrVid(travelsId, videoId);
				labelId = UserInterestService.findLabelIdByName(moreDetail.getDestination());
				
			}else if(null != sceneId) {    //浏览的是景点
				Scene scene = sceneService.findSceneById(sceneId);
				int startIndex = scene.getAddress().indexOf("省");
				int endIndex = scene.getAddress().indexOf("市");
				String nameString = scene.getAddress().substring(startIndex+1,endIndex);
				labelId = UserInterestService.findLabelIdByName(nameString);
			}
			//查询是否存在兴趣记录
			UserInterest uInterest = UserInterestService.findInterestByUserIdAndLabelId(userId, labelId);
			if(null != uInterest) {//如果有记录
				int j = UserInterestService.updateWeightByInterestId(uInterest.getInterestId(), 1);
				if(j > 0) {
					System.out.println("weight更新成功");
				}
			}else {
				int j = UserInterestService.addInterest(userId, labelId, 1);
				if(j > 0) {
					System.out.println("weight添加成功");
				}
			}
			System.out.println("添加一条浏览记录");
		}else {
			System.out.println("浏览记录添加失败");
		}
	}
}
