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
 * @author: 张璐婷
 * @date: 2021年1月25日 下午2:46:19       
 */
@Service
public class VideoService {
	
	@Resource
	private VideoMapper videoMapper;
	
	/**
	 * @Title: findVideoByTopicId
	 * @Description: 查询指定话题的视频
	 * @author: 张璐婷 
	 * @date: 2021年1月31日 下午3:22:21
	 */
	public List<Video> findVideoByTopicId(Integer topicId){
		return videoMapper.findVideoByTopicId(topicId);
	}
	
	/**
	 * @Title: findVideoFollowed
	 * @Description: 查询关注的人的视频
	 * @author: 张璐婷 
	 * @date: 2021年1月31日 下午2:38:55
	 */
	public List<Video> findVideoFollowed(Integer userId){
		return videoMapper.findVideoFollowed(userId);
	}
	
	/**
	 * @Title: findVideoByUserId
	 * @Description: 根据用户id值查询指定游记
	 * @author: 张璐婷 
	 * @date: 2021年1月31日 下午1:45:42
	 */
	public List<Video> findVideoByUserId(Integer userId){
		return videoMapper.findVideoByUserId(userId);
	}
	
	/**
	 * @Title: findVideoByLocation
	 * @Description: 查询指定地点的视频
	 * @author: 张璐婷 
	 * @date: 2021年1月31日 下午1:44:58
	 */
	public List<Video> findVideoByLocation(String location){
		return videoMapper.findVideoByLocation(location);
	}
	
	/**
	 * @Title: addAuditVideo
	 * @Description: 添加发布版视频
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午6:36:34
	 */
	public int addVideo(Video video) {
		return videoMapper.addVideo(video);
	}
	
	/**
	 * @Title: addVideoDetail
	 * @Description: 添加详细信息
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午7:04:58
	 */
	public int addVideoDetail(MoreDetail moreDetail) {
		return videoMapper.addVideoDetail(moreDetail);
	}
	
	/**
	 * @Title: updateDetailVideoIdById
	 * @Description: 更新详情的video_id
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午8:48:59
	 */
	public int updateDetailVideoIdById(Integer videoId,Integer moreId) {
		return videoMapper.updateDetailVideoIdById(videoId, moreId);
	}
	
	/**
	 * @Title: findAllVideo
	 * @Description: 查询所有发布版视频
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:57:52
	 */
	public List<Video> findAllVideo(){
		return videoMapper.findAllVideo();
	}

	
	/**
	 * @Title: findVideoById
	 * @Description: 根据ID值查询视频
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午5:40:58
	 */
	public Video findVideoById(Integer videoId) {
		return videoMapper.findVideoById(videoId);
	}
	
	/**
	 * @Title: deleteVideoById
	 * @Description: 根据ID值删除视频
	 * @author: 张璐婷 
	 * @date: 2021年1月22日 下午6:16:45
	 */
	public int deleteVideoById(Integer videoId) {
		return videoMapper.deleteVideoById(videoId);
	}
	
	/**
	 * @Title: deleteDetailByVideoId
	 * @Description: 删除详细信息
	 * @author: 张璐婷 
	 * @date: 2021年1月26日 上午11:41:00
	 */
	public int deleteDetailByVideoId(Integer videoId) {
		return videoMapper.deleteDetailByVideoId(videoId);
	}
	
	
	/**
	 * @Title: updateVideoById
	 * @Description: 根据ID值更新视频
	 * @author: 张璐婷 
	 * @date: 2021年1月26日 下午3:24:36
	 */
	public int updateVideoById(Video video) {
		return videoMapper.updateVideoById(video);
	}
	
	/**
	 * @Title: updateVideoDetail
	 * @Description: 更新详情
	 * @author: 张璐婷 
	 * @date: 2021年1月26日 下午3:26:55
	 */
	public int updateVideoDetail(MoreDetail detail) {
		return videoMapper.updateVideoDetail(detail);
	}
}
