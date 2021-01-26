package com.zhilv.travels.controller;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zhilv.travels.service.TravelsService;

/**   
 * @ClassName: TravelsController   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��20�� ����5:08:02       
 */
@RestController
@RequestMapping("/travels")
public class TravelsController {
	@Resource
	private TravelsService travelsService;
	
	@RequestMapping(value="/delete",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String delete(@RequestParam("travelsId")Integer travelsId) {
		int i = travelsService.deleteTravelsById(travelsId);
		travelsService.deleteDetailByTravelsId(travelsId);
		travelsService.deleteImgByTravelsId(travelsId);
		if(i > 0) {
			System.out.println("�μ�ɾ���ɹ�");
			return "OK";
		}else {
			System.out.println("�μ�ɾ��ʧ��");
			return "ERROR";
		}
	}

}
