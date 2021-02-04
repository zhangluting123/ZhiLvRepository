package com.zhilv.topic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.Topic;

/**   
 * @ClassName: TopicMapper   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��19�� ����5:16:47       
 */
public interface TopicMapper {

	/**
	 * @Title: addTopic
	 * @Description: ��ӷ����滰��
	 * @author: ����� 
	 * @date: 2021��1��19�� ����6:10:42
	 */
	public int addTopic(@Param("topic")Topic topic);
	
	/**
	 * @Title: findAllTopic
	 * @Description: ��ѯ���з����滰��
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:57:52
	 */
	public List<Topic> findAllTopic();
	
	/**
	 * @Title: findTopicByStr
	 * @Description: �����ַ���ģ����ѯ��Ӧtopic
	 * @author: ����� 
	 * @date: 2021��1��20�� ����11:46:18
	 */
	public List<Topic> findTopicByStr(@Param("str")String str);
	
	/**
	 * @Title: findMostCountTopicUsed
	 * @Description: �ҵ�ʹ����������topic�����μǺ���Ƶ�У�
	 * @author: ����� 
	 * @date: 2021��1��20�� ����2:08:19
	 */
	public List<Topic> findTwiceTopicUsed();
	
	/**
	 * @Title: findTopicById
	 * @Description: ����IDֵ��ѯ����
	 * @author: ����� 
	 * @date: 2021��1��20�� ����5:40:58
	 */
	public Topic findTopicById(@Param("topicId")Integer topicId);
	
}
