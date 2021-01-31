package com.zhilv.note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.entity.MoreDetail;
import com.zhilv.note.dao.NoteMapper;

/**   
 * @ClassName: NoteService   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��31�� ����1:54:04       
 */
@Service
public class NoteService {
	
	@Resource
	private NoteMapper noteMapper;
	
	/**
	 * @Title: findNoteByDestination
	 * @Description: ����Ŀ�ĵز�ѯ�μǻ���Ƶ
	 * @author: ����� 
	 * @date: 2021��1��31�� ����1:56:08
	 */
	public List<MoreDetail> findNoteByDestination(String destination){
		return noteMapper.findNoteByDestination(destination);
	}

}
