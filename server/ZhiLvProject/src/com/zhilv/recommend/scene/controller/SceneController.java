package com.zhilv.recommend.scene.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhilv.entity.Scene;
import com.zhilv.recommend.scene.service.SceneService;

/**   
 * @ClassName: SceneController   
 * @Description:TODO
 * @author: �����
 * @date: 2021��2��8�� ����9:14:30       
 */
@RestController
@RequestMapping("recommend/scene")
public class SceneController {

	@Resource
	private SceneService sceneService;
	
	/**
	 * 
	 * @description:��ѯ���о�����Ϣ
	 * @author :�����
	 * @date:2021��2��13��
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String list() {
		List<Scene> list = sceneService.findAllScene();
		list = screenUser(list);
		if(list.size() > 0) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String str = gson.toJson(list);
			return str;
		}else {
			return null;
		}
	}
	/**
	 * 
	 * @description:���ݵص��ѯ����
	 * @author :�����
	 * @date:2021��2��13��
	 * @param title
	 * @return
	 */
	@RequestMapping(value="/place",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String findByPlace(@RequestParam("title")String title) {
		List<Scene> list = sceneService.findSceneByTitle(title);
		list = screenUser(list);
		if(list.size() > 0) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String str = gson.toJson(list);System.out.println();
			return str;
		}else {
			return null;
		}
	}
	
	/**
	 * @Title: screenUser
	 * @Description: ɸѡ�û���Ϣ
	 * @author: ����� 
	 * @date: 2021��2��8�� ����8:39:07
	 */
	private static List<Scene> screenUser(List<Scene> list) {
		Set<Integer> userIdSet = new HashSet<>();
		Integer userId = null ;
		boolean flag = false;
		//ȡǰ��λ�༭������û���Ϣ,��ȥ���ظ��û�
		for(int i = 0; i < list.size(); ++i) {
			for(int j = 0; j < list.get(i).getSceneUpdate().size() && userIdSet.size() <= 3; ++j) {
				flag = false;
				userId = list.get(i).getSceneUpdate().get(j).getUser().getUserId();
				for(Integer k: userIdSet) {
					if(k == userId) {
						list.get(i).getSceneUpdate().remove(j);
						--j;
						flag = true;
						break;
					}
				}
				if(!flag) {
					userIdSet.add(userId);
				}
			}
			userIdSet.clear();
		}
		return list;
	}
}
