package com.zhilv.topic.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.Topic;
import com.zhilv.topic.dao.TopicMapper;

/**   
 * @ClassName: TopicService   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��19�� ����5:17:25       
 */
@Service
public class TopicService {
	
	@Resource
	private TopicMapper topicMapper;

	/**
	 * @Title: addTopic
	 * @Description: ��ӷ����滰��
	 * @author: ����� 
	 * @date: 2021��1��19�� ����6:10:42
	 */
	public int addTopic(Topic topic) {
		return topicMapper.addTopic(topic);
	}
	
	/**
	 * @Title: findAllTopic
	 * @Description: ��ѯ���з����滰��
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:57:52
	 */
	public List<Topic> findAllTopic(){
		return topicMapper.findAllTopic();
	}
	
	/**
	 * @Title: findTopicByStr
	 * @Description: �����ַ���ģ����ѯ��Ӧtopic
	 * @author: ����� 
	 * @date: 2021��1��20�� ����11:46:18
	 */
	public List<Topic> findTopicByStr(String str){
		return topicMapper.findTopicByStr(str);
	}
	
	/**
	 * @Title: findMostCountTopicUsed
	 * @Description: �ҵ�ʹ����������topic�����μǺ���Ƶ�У�
	 * @author: ����� 
	 * @date: 2021��1��20�� ����2:08:19
	 */
	public List<Topic> findTwiceTopicUsed(){
		return topicMapper.findTwiceTopicUsed();
	}
	
}
