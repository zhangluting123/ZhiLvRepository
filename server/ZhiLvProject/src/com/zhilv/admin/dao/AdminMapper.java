package com.zhilv.admin.dao;

import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
	
	/**
	 * @Title: addAdmin
	 * @Description: ��ӹ���Ա
	 * @author: �����
	 * @date: 2021��2��23�� ����5:31:18
	 */
	public int addAdmin(@Param("email")String email,@Param("name")String name,@Param("password")String password);
	
	/**
	 * @Title: findAdminByNameOrEmail
	 * @Description: 
	 * @author: �����
	 * @date: 2021��2��23�� ����5:31:48
	 */
	public int findAdminByNameOrEmail(@Param("name")String name, @Param("email")String email);
	
	/**
	 * @Title: findAdminByNameAndPwd
	 * @Description: 
	 * @author: �����
	 * @date: 2021��2��23�� ����5:32:36
	 */
	public int findAdminByNameAndPwd(@Param("name")String name,@Param("password")String password);

}
