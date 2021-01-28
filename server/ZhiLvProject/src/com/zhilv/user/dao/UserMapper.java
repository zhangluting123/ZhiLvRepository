package com.zhilv.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.Attention;
import com.zhilv.entity.User;


/**   
 * @ClassName: UserMapper   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月17日 下午3:37:13       
 */
public interface UserMapper {
	
	/**
	 * @Title: findUserByPhone
	 * @Description: 查询用户信息根据邮箱、电话或密码
	 * @author: 张璐婷 
	 * @date: 2021年1月17日 下午3:47:13
	 */
	public User findUserByPhoneAndEmail(@Param("phone")String phone,@Param("email")String email, @Param("password")String password);
	
	/**
	 * @Title: findUserByUserId
	 * @Description: 根据ID值查询用户信息
	 * @author: 张璐婷 
	 * @date: 2021年1月18日 上午10:27:35
	 */
	public User findUserByUserId(@Param("userId")Integer userId);
	
	/**
	 * @Title: updateUserPwd
	 * @Description: 忘记密码
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午1:54:23
	 */
	public int updateUserPwd(@Param("phone")String phone,@Param("email")String email, @Param("password")String password);
	
	/**
	 * @Title: addUsers
	 * @Description: 添加用户
	 * @author: 张璐婷 
	 * @date: 2021年1月17日 下午3:47:35
	 */
	public int addUser(@Param("user")User user);
	
	/**
	 * @Title: updateMsgOfUser
	 * @Description: 更新用户信息
	 * @author: 张璐婷 
	 * @date: 2021年1月17日 下午3:45:28
	 */
	public int updateMsgOfUser(@Param("user")User user);

	
	/**
	 * @Title: queryFollowed
	 * @Description: 查询关注列表
	 * @author: 张璐婷 
	 * @date: 2021年1月17日 下午3:44:19
	 */
	public List<User> findFollowed(@Param("userId")Integer userId);
	
	/**
	 * @Title: findFans
	 * @Description: 查询粉丝列表
	 * @author: 张璐婷 
	 * @date: 2021年1月18日 上午10:20:14
	 */
	public List<User> findFans(@Param("userId")Integer userId);
	
	/**
	 * @Title: findIfAttention
	 * @Description: 查询是否关注
	 * @author: 张璐婷 
	 * @date: 2021年1月17日 下午4:11:38
	 */
	public int findIfAttention(@Param("attention")Attention attention);
	
	/**
	 * @Title: addAttention
	 * @Description: 添加关注条目
	 * @author: 张璐婷 
	 * @date: 2021年1月17日 下午4:12:02
	 */
	public int addAttention(@Param("attention")Attention attention);
	
	/**
	 * @Title: deleteAttention
	 * @Description: 删除关注信息
	 * @author: 张璐婷 
	 * @date: 2021年1月17日 下午4:12:16
	 */
	public int deleteAttention(@Param("attention")Attention attention);
	
	
	
	
}
