package com.zhilv.recommend.scene.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhilv.entity.InterestLabel;
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
	 * @description:���ɾ����Ƽ��б�
	 * @author :������
	 * @date:2021��2��18��
	 * @param UserId
	 * @return
	 */
	// http://localhost:8080/ZhiLvProject/recommend/scene/getRecommendList?userId=6
	@RequestMapping(value="/getRecommendList",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String getRecommendList(@RequestParam(value="userId",required=false)Integer userId) {
		List<Scene> recommendList = new ArrayList<Scene>();
		if(null != userId) {
			List<Scene> userInterestList = getSceneByUserInterest(userId);
			recommendList.addAll(userInterestList);
		}
		List<Scene> randomList = recommendRandom();
		recommendList.addAll(randomList);
		recommendList = removeRepeat(recommendList);
		recommendList = screenUser(recommendList);
		if(recommendList.size()>0) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String str = gson.toJson(recommendList);
			return str;
		}else {
			return null;
		}
		
	}
	/**
	 * @description:��ѯ�û���Ȥ�б�
	 * @author :������
	 * @date:2021��2��18��
	 * @param userId
	 * @return
	 */
	public List<Scene> getSceneByUserInterest(Integer userId){
		List<Scene> scenesList = new ArrayList<Scene>();
		List<InterestLabel> userInterest = sceneService.findUserInterest(userId);
//		System.out.println(userInterest);
		for(int i = 0; i<userInterest.size();i++) {
			scenesList.addAll(findByAddress(userInterest.get(i).getLabelName()));
		}
		return scenesList;
	}
	
	/**
	 * @description:����Ƽ����㣬���ϵͳ����������
	 * @author :������
	 * @date:2021��2��18��
	 * @return
	 */
	
	public List<Scene> recommendRandom(){
		List<Scene> allScenes = sceneService.findAllScene();
		List<Scene> ranList=new ArrayList<Scene>();
		Random r = new Random();
		for(int i=0;i<10;i++) {
			int ran = r.nextInt(allScenes.size());
			ranList.add(allScenes.get(ran));
		}
		return ranList;
	}
	/**
	 * @description:���ݵ�ַ��ѯ����
	 * @author :������
	 * @date:2021��2��18��
	 * @param title
	 * @return
	 */
	public List<Scene> findByAddress(String title) {
		List<Scene> list = sceneService.findSceneByTitle(title);
		return list;
	}
	
	/**
	 * @description:ȥ���б����ظ��ľ���
	 * @author :������
	 * @date:2021��2��18��
	 * @param scenes
	 * @return
	 */
	public List<Scene> removeRepeat(List<Scene> scenes){
		List<Integer> idList=new ArrayList<Integer>();
		List<Scene> resultList = new ArrayList<Scene>();
		for(int i=0 ; i<scenes.size() ;i++) {
			if(idList.contains(scenes.get(i).getSceneId())==false) {
				resultList.add(scenes.get(i));
				idList.add(scenes.get(i).getSceneId());
			}
		}
		
		return resultList;
	}
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
			String str = gson.toJson(list);
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
