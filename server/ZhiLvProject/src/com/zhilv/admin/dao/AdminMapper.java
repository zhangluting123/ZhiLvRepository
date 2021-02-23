package com.zhilv.admin.dao;

import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
	
	/**
	 * @Title: addAdmin
	 * @Description: 添加管理员
	 * @author: 张璐婷
	 * @date: 2021年2月23日 下午5:31:18
	 */
	public int addAdmin(@Param("email")String email,@Param("name")String name,@Param("password")String password);
	
	/**
	 * @Title: findAdminByNameOrEmail
	 * @Description: 
	 * @author: 张璐婷
	 * @date: 2021年2月23日 下午5:31:48
	 */
	public int findAdminByNameOrEmail(@Param("name")String name, @Param("email")String email);
	
	/**
	 * @Title: findAdminByNameAndPwd
	 * @Description: 
	 * @author: 张璐婷
	 * @date: 2021年2月23日 下午5:32:36
	 */
	public int findAdminByNameAndPwd(@Param("name")String name,@Param("password")String password);

}
