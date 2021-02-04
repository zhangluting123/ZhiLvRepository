package com.zhilv.video.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.MoreDetail;
import com.zhilv.entity.Video;
import com.zhilv.video.dao.VideoMapper;

/**   
 * @ClassName: VideoService   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��25�� ����2:46:19       
 */
@Service
public class VideoService {
	
	@Resource
	private VideoMapper videoMapper;
	
	/**
	 * @Title: findVideoByTopicId
	 * @Description: ��ѯָ���������Ƶ
	 * @author: ����� 
	 * @date: 2021��1��31�� ����3:22:21
	 */
	public List<Video> findVideoByTopicId(Integer topicId){
		return videoMapper.findVideoByTopicId(topicId);
	}
	
	/**
	 * @Title: findVideoFollowed
	 * @Description: ��ѯ��ע���˵���Ƶ
	 * @author: ����� 
	 * @date: 2021��1��31�� ����2:38:55
	 */
	public List<Video> findVideoFollowed(Integer userId){
		return videoMapper.findVideoFollowed(userId);
	}
	
	/**
	 * @Title: findVideoByUserId
	 * @Description: �����û�idֵ��ѯָ���μ�
	 * @author: ����� 
	 * @date: 2021��1��31�� ����1:45:42
	 */
	public List<Video> findVideoByUserId(Integer userId){
		return videoMapper.findVideoByUserId(userId);
	}
	
	/**
	 * @Title: findVideoByLocation
	 * @Description: ��ѯָ���ص����Ƶ
	 * @author: ����� 
	 * @date: 2021��1��31�� ����1:44:58
	 */
	public List<Video> findVideoByLocation(String location){
		return videoMapper.findVideoByLocation(location);
	}
	
	/**
	 * @Title: addAuditVideo
	 * @Description: ��ӷ�������Ƶ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����6:36:34
	 */
	public int addVideo(Video video) {
		return videoMapper.addVideo(video);
	}
	
	/**
	 * @Title: addVideoDetail
	 * @Description: �����ϸ��Ϣ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����7:04:58
	 */
	public int addVideoDetail(MoreDetail moreDetail) {
		return videoMapper.addVideoDetail(moreDetail);
	}
	
	/**
	 * @Title: updateDetailVideoIdById
	 * @Description: ���������video_id
	 * @author: ����� 
	 * @date: 2021��1��20�� ����8:48:59
	 */
	public int updateDetailVideoIdById(Integer videoId,Integer moreId) {
		return videoMapper.updateDetailVideoIdById(videoId, moreId);
	}
	
	/**
	 * @Title: findAllVideo
	 * @Description: ��ѯ���з�������Ƶ
	 * @author: ����� 
	 * @date: 2021��1��19�� ����7:57:52
	 */
	public List<Video> findAllVideo(){
		return videoMapper.findAllVideo();
	}

	
	/**
	 * @Title: findVideoById
	 * @Description: ����IDֵ��ѯ��Ƶ
	 * @author: ����� 
	 * @date: 2021��1��20�� ����5:40:58
	 */
	public Video findVideoById(Integer videoId) {
		return videoMapper.findVideoById(videoId);
	}
	
	/**
	 * @Title: deleteVideoById
	 * @Description: ����IDֵɾ����Ƶ
	 * @author: ����� 
	 * @date: 2021��1��22�� ����6:16:45
	 */
	public int deleteVideoById(Integer videoId) {
		return videoMapper.deleteVideoById(videoId);
	}
	
	/**
	 * @Title: deleteDetailByVideoId
	 * @Description: ɾ����ϸ��Ϣ
	 * @author: ����� 
	 * @date: 2021��1��26�� ����11:41:00
	 */
	public int deleteDetailByVideoId(Integer videoId) {
		return videoMapper.deleteDetailByVideoId(videoId);
	}
	
	
	/**
	 * @Title: updateVideoById
	 * @Description: ����IDֵ������Ƶ
	 * @author: ����� 
	 * @date: 2021��1��26�� ����3:24:36
	 */
	public int updateVideoById(Video video) {
		return videoMapper.updateVideoById(video);
	}
	
	/**
	 * @Title: updateVideoDetail
	 * @Description: ��������
	 * @author: ����� 
	 * @date: 2021��1��26�� ����3:26:55
	 */
	public int updateVideoDetail(MoreDetail detail) {
		return videoMapper.updateVideoDetail(detail);
	}
}
