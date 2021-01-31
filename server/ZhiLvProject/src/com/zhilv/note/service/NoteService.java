package com.zhilv.note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.MoreDetail;
import com.zhilv.note.dao.NoteMapper;

/**   
 * @ClassName: NoteService   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月31日 下午1:54:04       
 */
@Service
public class NoteService {
	
	@Resource
	private NoteMapper noteMapper;
	
	/**
	 * @Title: findNoteByDestination
	 * @Description: 根据目的地查询游记或视频
	 * @author: 张璐婷 
	 * @date: 2021年1月31日 下午1:56:08
	 */
	public List<MoreDetail> findNoteByDestination(String destination){
		return noteMapper.findNoteByDestination(destination);
	}

}
