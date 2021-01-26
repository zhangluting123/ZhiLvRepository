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
	 * @Title: findVideoByStr
	 * @Description: �����ַ���ģ����ѯ��Ӧvideo
	 * @author: ����� 
	 * @date: 2021��1��20�� ����11:46:18
	 */
	public List<Video> findVideoByStr(@Param("str")String str);
	
	
	/**
	 * @Title: findVideoById
	 * @Description: ����IDֵ��ѯ��Ƶ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����5:40:58
	 */
	public Travels findVideoById(@Param("videoId")Integer videoId);
	
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
