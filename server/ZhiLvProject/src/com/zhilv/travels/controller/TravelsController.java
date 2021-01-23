package com.zhilv.travels.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.zhilv.entity.Note;
import com.zhilv.entity.Travels;
import com.zhilv.travels.service.TravelsService;

/**   
 * @ClassName: TravelsController   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月20日 下午5:08:02       
 */
@RestController
@RequestMapping("/travels")
public class TravelsController {
	@Resource
	private TravelsService travelsService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String list() {
		List<Travels> list = travelsService.findAllTravels();
		List<Note> noteList = new ArrayList<Note>();
		for(Travels travels: list) {
			Note note = new Note();
			note.setFlag(true);
			note.setTime(travels.getUploadTime());
			note.setTravels(travels);
			noteList.add(note);
		}
		//根据时间note进行排序
	
		if(noteList.size() > 0) {
			Gson gson = new Gson();
			String str = gson.toJson(noteList);
			return str;
		}else {
			return null;
		}
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String delete(@RequestParam("travelsId")Integer travelsId) {
		int i = travelsService.deleteTravelsById(travelsId);
		if(i > 0) {
			System.out.println("游记删除成功");
			return "OK";
		}else {
			System.out.println("游记删除失败");
			return "ERROR";
		}
	}

}
