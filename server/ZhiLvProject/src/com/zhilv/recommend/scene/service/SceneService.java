package com.zhilv.recommend.scene.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.InterestLabel;
import com.zhilv.entity.Scene;
import com.zhilv.recommend.scene.dao.SceneMapper;

/**   
 * @ClassName: SceneService   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年2月8日 上午9:15:13       
 */
@Service
public class SceneService {

	@Resource
	private SceneMapper sceneMapper;
	/**
	 * @description:查找用户兴趣集合
	 * @author :张梦如
	 * @date:2021年2月18日
	 * @param UserId
	 * @return
	 */
	public List<InterestLabel> findUserInterest(Integer UserId){
		return sceneMapper.findUserInterest(UserId);
	}
	
	/**
	 * @Title: updateScene
	 * @Description: 更新景点信息
	 * @author: 张璐婷 
	 * @date: 2021年2月8日 上午11:07:45
	 */
	public int updateScene(Scene scene) {
		return sceneMapper.updateScene(scene);
	}
	
	/**
	 * @Title: addSceneUpdateMsg
	 * @Description: 添加更新信息
	 * @author: 张璐婷 
	 * @date: 2021年2月8日 上午11:08:51
	 */
	public int addSceneUpdateMsg(Integer userId, Integer sceneId, Date updateTime) {
		return sceneMapper.addSceneUpdateMsg(userId, sceneId, updateTime);
	}

	/**
	 * @Title: findAllScene
	 * @Description: 查询所有景点
	 * @author: 张璐婷 
	 * @date: 2021年2月8日 下午12:03:26
	 */
	public List<Scene> findAllScene(){
		return sceneMapper.findAllScene();
	}
	
	/**
	 * @Title: findSceneByTitle
	 * @Description: 根据目的地查询景点详细信息
	 * @author: 张璐婷
	 * @date: 2021年2月9日 下午1:06:20
	 */
	public List<Scene> findSceneByTitle(String title){
		return sceneMapper.findSceneByTitle(title);
	}
	
	/**
	 * @Title: findSceneById
	 * @Description: 根据ID值查找景点信息
	 * @author: 张璐婷
	 * @date: 2021年2月10日 下午3:12:20
	 */
	public Scene findSceneById(Integer sceneId) {
		return sceneMapper.findSceneById(sceneId);
	}
}
