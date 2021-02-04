package com.zhilv.note.dao;

import java.util.List;

import com.zhilv.entity.MoreDetail;

/**   
 * @ClassName: NoteMapper   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月31日 下午1:53:20       
 */
public interface NoteMapper {
	
	/**
	 * @Title: findNoteByDestination
	 * @Description: 根据目的地查询游记或视频
	 * @author: 张璐婷 
	 * @date: 2021年1月31日 下午1:56:08
	 */
	public List<MoreDetail> findNoteByDestination(String destination);

}
