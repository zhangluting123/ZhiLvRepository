package com.zhilv.topic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.Topic;

/**   
 * @ClassName: TopicMapper   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月19日 下午5:16:47       
 */
public interface TopicMapper {

	/**
	 * @Title: addTopic
	 * @Description: 添加发布版话题
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午6:10:42
	 */
	public int addTopic(@Param("topic")Topic topic);
	
	/**
	 * @Title: findAllTopic
	 * @Description: 查询所有发布版话题
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:57:52
	 */
	public List<Topic> findAllTopic();
	
	/**
	 * @Title: findTopicByStr
	 * @Description: 根据字符串模糊查询相应topic
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 上午11:46:18
	 */
	public List<Topic> findTopicByStr(@Param("str")String str);
	
	/**
	 * @Title: findMostCountTopicUsed
	 * @Description: 找到使用最多的两个topic（在游记和视频中）
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午2:08:19
	 */
	public List<Topic> findTwiceTopicUsed();
	
	/**
	 * @Title: findTopicById
	 * @Description: 根据ID值查询话题
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午5:40:58
	 */
	public Topic findTopicById(@Param("topicId")Integer topicId);
	
}
