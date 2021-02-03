package com.zhilv.video.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.MoreDetail;
import com.zhilv.entity.Travels;
import com.zhilv.entity.Video;

/**   
 * @ClassName: VideoMapper   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��25�� ����2:45:45       
 */
public interface VideoMapper {
	
	/**
	 * @Title: findVideoByTopicId
	 * @Description: ��ѯָ���������Ƶ
	 * @author: ����� 
	 * @date: 2021��1��31�� ����3:22:21
	 */
	public List<Video> findVideoByTopicId(Integer topicId);
	
	/**
	 * @Title: findVideoFollowed
	 * @Description: ��ѯ��ע���˵���Ƶ
	 * @author: ����� 
	 * @date: 2021��1��31�� ����2:38:55
	 */
	public List<Video> findVideoFollowed(Integer userId);
	
	/**
	 * @Title: findVideoByUserId
	 * @Description: �����û�idֵ��ѯָ���μ�
	 * @author: ����� 
	 * @date: 2021��1��31�� ����1:45:42
	 */
	public List<Video> findVideoByUserId(Integer userId);
	
	/**
	 * @Title: findVideoByLocation
	 * @Description: ��ѯָ���ص����Ƶ
	 * @author: ����� 
	 * @date: 2021��1��31�� ����1:44:58
	 */
	public List<Video> findVideoByLocation(String location);
	
	/**
	 * @Title: addAuditVideo
	 * @Description: ��ӷ�������Ƶ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����6:36:34
	 */
	public int addVideo(@Param("video")Video video);
	
	/**
	 * @Title: addVideoDetail
	 * @Description: �����ϸ��Ϣ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����7:04:58
	 */
	public int addVideoDetail(@Param("detail")MoreDetail moreDetail);
	
	/**
	 * @Title: updateDetailVideoIdById
	 * @Description: ���������video_id
	 * @author: ����� 
	 * @date: 2021��1��20�� ����8:48:59
	 */
	public int updateDetailVideoIdById(@Param("videoId")Integer videoId,@Param("moreId")Integer moreId);
	
	/**
	 * @Title: findAllVideo
	 * @Description: ��ѯ���з�������Ƶ
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:57:52
	 */
	public List<Video> findAllVideo();
	
	
	/**
	 * @Title: findVideoById
	 * @Description: ����IDֵ��ѯ��Ƶ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����5:40:58
	 */
	public Video findVideoById(@Param("videoId")Integer videoId);
	
	/**
	 * @Title: deleteVideoById
	 * @Description: ����IDֵɾ����Ƶ
	 * @author: ����� 
	 * @date: 2021��1��22�� ����6:16:45
	 */
	public int deleteVideoById(@Param("videoId")Integer videoId);
	
	/**
	 * @Title: deleteDetailByVideoId
	 * @Description: ɾ����ϸ��Ϣ
	 * @author: ����� 
	 * @date: 2021��1��26�� ����11:41:00
	 */
	public int deleteDetailByVideoId(@Param("videoId")Integer videoId);
	
	/**
	 * @Title: updateVideoById
	 * @Description: ����IDֵ������Ƶ
	 * @author: ����� 
	 * @date: 2021��1��26�� ����3:24:36
	 */
	public int updateVideoById(@Param("video")Video video);
	
	/**
	 * @Title: updateVideoDetail
	 * @Description: ��������
	 * @author: ����� 
	 * @date: 2021��1��26�� ����3:26:55
	 */
	public int updateVideoDetail(@Param("detail")MoreDetail detail);
	
}
