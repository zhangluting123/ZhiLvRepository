package com.zhilv.admin.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhilv.admin.dao.AdminMapper;

@Service
public class AdminService {
	
	@Resource
	private AdminMapper adminMapper;
	
	/**
	 * @Title: addAdmin
	 * @Description: 添加管理员
	 * @author: 张璐婷
	 * @date: 2021年2月23日 下午5:31:18
	 */
	public int addAdmin(String email,String name,String password) {
		return adminMapper.addAdmin(email, name, password);
	}
	
	/**
	 * @Title: findAdminByNameOrEmail
	 * @Description: 
	 * @author: 张璐婷
	 * @date: 2021年2月23日 下午5:31:48
	 */
	public int findAdminByNameOrEmail(String name, String email) {
		return adminMapper.findAdminByNameOrEmail(name, email);
	}
	
	/**
	 * @Title: findAdminByNameAndPwd
	 * @Description: 
	 * @author: 张璐婷
	 * @date: 2021年2月23日 下午5:32:36
	 */
	public int findAdminByNameAndPwd(String name, String password) {
		return adminMapper.findAdminByNameAndPwd(name, password);
	}


}
