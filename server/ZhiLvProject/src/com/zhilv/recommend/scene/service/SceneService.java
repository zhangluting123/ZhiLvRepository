package com.zhilv.recommend.scene.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.Scene;
import com.zhilv.recommend.scene.dao.SceneMapper;

/**   
 * @ClassName: SceneService   
 * @Description:TODO
 * @author: �����
 * @date: 2021��2��8�� ����9:15:13       
 */
@Service
public class SceneService {

	@Resource
	private SceneMapper sceneMapper;
	
	/**
	 * @Title: updateScene
	 * @Description: ���¾�����Ϣ
	 * @author: ����� 
	 * @date: 2021��2��8�� ����11:07:45
	 */
	public int updateScene(Scene scene) {
		return sceneMapper.updateScene(scene);
	}
	
	/**
	 * @Title: addSceneUpdateMsg
	 * @Description: ��Ӹ�����Ϣ
	 * @author: ����� 
	 * @date: 2021��2��8�� ����11:08:51
	 */
	public int addSceneUpdateMsg(Integer userId, Integer sceneId, Date updateTime) {
		return sceneMapper.addSceneUpdateMsg(userId, sceneId, updateTime);
	}

	/**
	 * @Title: findAllScene
	 * @Description: ��ѯ���о���
	 * @author: ����� 
	 * @date: 2021��2��8�� ����12:03:26
	 */
	public List<Scene> findAllScene(){
		return sceneMapper.findAllScene();
	}
	
	/**
	 * @Title: findSceneByTitle
	 * @Description: ����Ŀ�ĵز�ѯ������ϸ��Ϣ
	 * @author: �����
	 * @date: 2021��2��9�� ����1:06:20
	 */
	public List<Scene> findSceneByTitle(String title){
		return sceneMapper.findSceneByTitle(title);
	}
}
