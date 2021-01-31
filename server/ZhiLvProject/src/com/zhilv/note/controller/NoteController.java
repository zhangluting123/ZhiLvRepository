 package com.zhilv.note.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhilv.entity.MoreDetail;
import com.zhilv.entity.Note;
import com.zhilv.entity.Travels;
import com.zhilv.entity.UserCollection;
import com.zhilv.entity.UserGood;
import com.zhilv.entity.Video;
import com.zhilv.note.dao.NoteMapper;
import com.zhilv.note.service.NoteService;
import com.zhilv.travels.service.TravelsService;
import com.zhilv.usercollection.service.CollectionService;
import com.zhilv.usergood.service.GoodService;
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
	private NoteService noteService;
	@Resource
	private TravelsService travelsService;
	@Resource
	private VideoService videoService;
	@Resource
	private GoodService goodService;
	@Resource
	private CollectionService collectionService;
	
	@RequestMapping(value="/topiclist",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String topicList(@RequestParam("topicId")Integer topicId) {
		List<Travels> list = travelsService.findTravelsByTopicId(topicId);
		List<Video> videoList = videoService.findVideoByTopicId(topicId);
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
	
	@RequestMapping(value="/followlist",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String followList(@RequestParam("userId")Integer userId) {
		List<Travels> list = travelsService.findTravelsFollowed(userId);
		List<Video> videoList = videoService.findVideoFollowed(userId);
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
	
	@RequestMapping(value="/locationlist",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String locationList(@RequestParam("location")String location) {
		List<Travels> list = travelsService.findTravelsByLocation(location);
		List<Video> videoList = videoService.findVideoByLocation(location);
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
	
	@RequestMapping(value="/destinationlist",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String DestinationList(@RequestParam("destination")String destination) {
		List<MoreDetail> list = noteService.findNoteByDestination(destination);
		List<Note> noteList = new ArrayList<Note>();
		Note note = null;
		for(int i = 0; i < list.size(); ++i) {
			if(null != list.get(i).getTravels()) {
				note = new Note();
				note.setFlag(true);
				note.setTime(list.get(i).getTravels().getUploadTime());
				note.setTravels(list.get(i).getTravels());
				noteList.add(note);
			}else {
				note = new Note();
				note.setFlag(false);
				note.setTime(list.get(i).getVideo().getUploadTime());
				note.setVideo(list.get(i).getVideo());
				noteList.add(note);
			}
		}
		if(noteList.size() > 0) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String str = gson.toJson(noteList);
			return str;
		}else {
			return null;
		}
	}
	
	@RequestMapping(value="/userlist",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String userList(@RequestParam("userId")Integer userId) {
		List<Travels> list = travelsService.findTravelsByUserId(userId);
		List<Video> videoList = videoService.findVideoByUserId(userId);
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
	@RequestMapping(value="/goodlist",method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String goodList(@RequestParam("userId")Integer userId) {
		List<UserGood> list = goodService.findAllGood(userId);
		List<Note> noteList = new ArrayList<Note>();
		Note note = null;
		for(int i = 0; i < list.size(); ++i) {
			if(null != list.get(i).getTravels()) {
				note = new Note();
				note.setFlag(true);
				note.setTime(list.get(i).getTime());
				note.setTravels(list.get(i).getTravels());
				noteList.add(note);
			}else {
				note = new Note();
				note.setFlag(false);
				note.setTime(list.get(i).getTime());
				note.setVideo(list.get(i).getVideo());
				noteList.add(note);
			}
		}
		if(noteList.size() > 0) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String str = gson.toJson(noteList);
			return str;
		}else {
			return null;
		}
	}
	
	@RequestMapping(value="/collectionlist",method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String collectionList(@RequestParam("userId")Integer userId) {
		List<UserCollection> list = collectionService.findAllCollection(userId);
		List<Note> noteList = new ArrayList<Note>();
		Note note = null;
		for(int i = 0; i < list.size(); ++i) {
			if(null != list.get(i).getTravels()) {
				note = new Note();
				note.setFlag(true);
				note.setTime(list.get(i).getTime());
				note.setTravels(list.get(i).getTravels());
				noteList.add(note);
			}else {
				note = new Note();
				note.setFlag(false);
				note.setTime(list.get(i).getTime());
				note.setVideo(list.get(i).getVideo());
				noteList.add(note);
			}
		}
		if(noteList.size() > 0) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String str = gson.toJson(noteList);
			return str;
		}else {
			return null;
		}
	}
}
