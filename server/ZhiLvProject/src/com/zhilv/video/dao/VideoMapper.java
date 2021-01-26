package com.zhilv.video.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.MoreDetail;
import com.zhilv.entity.Travels;
import com.zhilv.entity.Video;

/**   
 * @ClassName: VideoMapper   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月25日 下午2:45:45       
 */
public interface VideoMapper {
	
	/**
	 * @Title: addAuditVideo
	 * @Description: 添加发布版视频
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午6:36:34
	 */
	public int addVideo(@Param("video")Video video);
	
	/**
	 * @Title: addVideoDetail
	 * @Description: 添加详细信息
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午7:04:58
	 */
	public int addVideoDetail(@Param("detail")MoreDetail moreDetail);
	
	/**
	 * @Title: updateDetailVideoIdById
	 * @Description: 更新详情的video_id
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午8:48:59
	 */
	public int updateDetailVideoIdById(@Param("videoId")Integer videoId,@Param("moreId")Integer moreId);
	
	/**
	 * @Title: findAllVideo
	 * @Description: 查询所有发布版视频
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:57:52
	 */
	public List<Video> findAllVideo();
	
	/**
	 * @Title: findVideoByStr
	 * @Description: 根据字符串模糊查询相应video
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 上午11:46:18
	 */
	public List<Video> findVideoByStr(@Param("str")String str);
	
	
	/**
	 * @Title: findVideoById
	 * @Description: 根据ID值查询视频
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午5:40:58
	 */
	public Travels findVideoById(@Param("videoId")Integer videoId);
	
	/**
	 * @Title: deleteVideoById
	 * @Description: 根据ID值删除视频
	 * @author: 张璐婷 
	 * @date: 2021年1月22日 下午6:16:45
	 */
	public int deleteVideoById(@Param("videoId")Integer videoId);
	
	/**
	 * @Title: deleteDetailByVideoId
	 * @Description: 删除详细信息
	 * @author: 张璐婷 
	 * @date: 2021年1月26日 上午11:41:00
	 */
	public int deleteDetailByVideoId(@Param("videoId")Integer videoId);
	
	/**
	 * @Title: updateVideoById
	 * @Description: 根据ID值更新视频
	 * @author: 张璐婷 
	 * @date: 2021年1月26日 下午3:24:36
	 */
	public int updateVideoById(@Param("video")Video video);
	
	/**
	 * @Title: updateVideoDetail
	 * @Description: 更新详情
	 * @author: 张璐婷 
	 * @date: 2021年1月26日 下午3:26:55
	 */
	public int updateVideoDetail(@Param("detail")MoreDetail detail);
	
}
