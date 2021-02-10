package com.zhilv.topic.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.Topic;
import com.zhilv.topic.dao.TopicMapper;

/**   
 * @ClassName: TopicService   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月19日 下午5:17:25       
 */
@Service
public class TopicService {
	
	@Resource
	private TopicMapper topicMapper;

	/**
	 * @Title: addTopic
	 * @Description: 添加发布版话题
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午6:10:42
	 */
	public int addTopic(Topic topic) {
		return topicMapper.addTopic(topic);
	}
	
	/**
	 * @Title: findAllTopic
	 * @Description: 查询所有发布版话题
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:57:52
	 */
	public List<Topic> findAllTopic(){
		return topicMapper.findAllTopic();
	}
	
	/**
	 * @Title: findTopicByStr
	 * @Description: 根据字符串模糊查询相应topic
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 上午11:46:18
	 */
	public List<Topic> findTopicByStr(String str){
		return topicMapper.findTopicByStr(str);
	}
	
	/**
	 * @Title: findMostCountTopicUsed
	 * @Description: 找到使用最多的两个topic（在游记和视频中）
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午2:08:19
	 */
	public List<Topic> findTwiceTopicUsed(){
		return topicMapper.findTwiceTopicUsed();
	}
	
}
