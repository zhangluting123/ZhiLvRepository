package com.zhilv.note.dao;

import java.util.List;

import com.zhilv.entity.MoreDetail;

/**   
 * @ClassName: NoteMapper   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��31�� ����1:53:20       
 */
public interface NoteMapper {
	
	/**
	 * @Title: findNoteByDestination
	 * @Description: ����Ŀ�ĵز�ѯ�μǻ���Ƶ
	 * @author: ����� 
	 * @date: 2021��1��31�� ����1:56:08
	 */
	public List<MoreDetail> findNoteByDestination(String destination);

}
