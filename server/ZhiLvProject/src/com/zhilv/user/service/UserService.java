package com.zhilv.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.zhilv.entity.Attention;
import com.zhilv.entity.User;
import com.zhilv.user.dao.UserMapper;

/**   
 * @ClassName: UserService   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月17日 下午3:40:51       
 */
@Service
public class UserService {
	
	@Resource
	private UserMapper userMapper;
	
	/**
	 * @Title: findUserByPhone
	 * @Description: 查询用户信息根据邮箱、电话或密码
	 * @author: 张璐婷 
	 * @date: 2021年1月17日 下午3:47:13
	 */
	public User findUserByPhoneAndEmail(String phone,String email,String password) {
		return userMapper.findUserByPhoneAndEmail(phone, email, password);
	}
	/**
	 * @Title: updateUserPwd
	 * @Description: 忘记密码
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午1:54:23
	 */
	public int updateUserPwd(String phone,String email,String password) {
		return userMapper.updateUserPwd(phone, email, password);
	}
	/**
	 * @Title: findUserByUserId
	 * @Description: 根据ID值查询用户信息
	 * @author: 张璐婷 
	 * @date: 2021年1月18日 上午10:27:35
	 */
	public User findUserByUserId(Integer userId) {
		return userMapper.findUserByUserId(userId);
	}
	
	/**
	 * @Title: addUsers
	 * @Description: 添加用户
	 * @author: 张璐婷 
	 * @date: 2021年1月17日 下午3:47:35
	 */
	public int addUser(User user) {
		return userMapper.addUser(user);
	}
	
	/**
	 * @Title: updateMsgOfUser
	 * @Description: 更新用户信息
	 * @author: 张璐婷 
	 * @date: 2021年1月17日 下午3:45:28
	 */
	public int updateMsgOfUser(User user) {
		return userMapper.updateMsgOfUser(user);
	}
	
	/**
	 * @Title: queryFollowed
	 * @Description: 查询关注列表
	 * @author: 张璐婷 
	 * @date: 2021年1月17日 下午3:44:19
	 */
	public List<User> findFollowed(Integer userId){
		return userMapper.findFollowed(userId);
	}
	
	/**
	 * @Title: findFans
	 * @Description: 查询粉丝列表
	 * @author: 张璐婷 
	 * @date: 2021年1月18日 上午10:20:14
	 */
	public List<User> findFans(Integer userId){
		return userMapper.findFans(userId);
	}
	
	/**
	 * @Title: findIfAttention
	 * @Description: 查询是否关注
	 * @author: 张璐婷 
	 * @date: 2021年1月17日 下午4:11:38
	 */
	public int findIfAttention(Attention attention) {
		return userMapper.findIfAttention(attention);
	}
	
	/**
	 * @Title: addAttention
	 * @Description: 添加关注条目
	 * @author: 张璐婷 
	 * @date: 2021年1月17日 下午4:12:02
	 */
	public int addAttention(Attention attention) {
		return userMapper.addAttention(attention);
	}
	
	/**
	 * @Title: deleteAttention
	 * @Description: 删除关注信息
	 * @author: 张璐婷 
	 * @date: 2021年1月17日 下午4:12:16
	 */
	public int deleteAttention(Attention attention) {
		return userMapper.deleteAttention(attention);
	}
	
	/**
	 * @Title: findUserByName
	 * @Description: 根据用户名查询用户
	 * @author: 张璐婷 
	 * @date: 2021年2月2日 上午11:53:31
	 */
	public User findUserByName(String userName){
		return userMapper.findUserByName(userName);
	}
	
	/**
	 * @Title: findAllUser
	 * @Description: 查询所有用户
	 * @author: 张璐婷 
	 * @date: 2021年2月2日 下午1:56:26
	 */
	public List<User> findAllUser(){
		return userMapper.findAllUser();
	}
	
	/**
	 * @Title: deleteUserById
	 * @Description: 删除用户信息
	 * @author: 张璐婷 
	 * @date: 2021年2月2日 下午7:48:53
	 */
	public int deleteUserById(Integer userId) {
		return userMapper.deleteUserById(userId);
	}
	
	/**
	 * @Title: findForPage
	 * @Description: 分页查询
	 * @author: 张璐婷 
	 * @date: 2021年2月2日 下午7:55:28
	 */
	public List<User> findForPage(int startIndex, int pageSize){
		return userMapper.findForPage(startIndex, pageSize);
	}
	
	/**
	 * @Title: findCountUser
	 * @Description: 查询用户数量
	 * @author: 张璐婷 
	 * @date: 2021年2月2日 下午7:55:58
	 */
	public int findCountUser() {
		return userMapper.findCountUser();
	}
}
