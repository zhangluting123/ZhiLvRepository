package com.zhilv.note.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhilv.entity.Note;
import com.zhilv.entity.Travels;
import com.zhilv.entity.Video;
import com.zhilv.travels.service.TravelsService;
import com.zhilv.util.SortUtil;
import com.zhilv.video.service.VideoService;

/**   
 * @ClassName: DetailController   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月25日 下午6:12:33       
 */
@RestController
@RequestMapping("/note")
public class NoteController {

	@Resource
	private TravelsService travelsService;
	
	@Resource
	private VideoService videoService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String list() {
		List<Travels> list = travelsService.findAllTravels();
		List<Video> videoList = videoService.findAllVideo();
		List<Note> noteList = new ArrayList<Note>();
		for(Travels travels: list) {
			Note note = new Note();
			note.setFlag(true);
			note.setTime(travels.getUploadTime());
			note.setTravels(travels);
			noteList.add(note);
		}
		for(Video video: videoList) {
			Note note = new Note();
			note.setFlag(false);
			note.setTime(video.getUploadTime());
			note.setVideo(video);
			noteList.add(note);
		}
		//根据时间对note进行排序
		SortUtil.sortList(noteList, "time", "DESC");
		
		if(noteList.size() > 0) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String str = gson.toJson(noteList);
			return str;
		}else {
			return null;
		}
	}
}
