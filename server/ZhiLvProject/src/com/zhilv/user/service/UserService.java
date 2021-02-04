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
 * @author: �����
 * @date: 2021��1��17�� ����3:40:51       
 */
@Service
public class UserService {
	
	@Resource
	private UserMapper userMapper;
	
	/**
	 * @Title: findUserByPhone
	 * @Description: ��ѯ�û���Ϣ�������䡢�绰������
	 * @author: ����� 
	 * @date: 2021��1��17�� ����3:47:13
	 */
	public User findUserByPhoneAndEmail(String phone,String email,String password) {
		return userMapper.findUserByPhoneAndEmail(phone, email, password);
	}
	/**
	 * @Title: updateUserPwd
	 * @Description: ��������
	 * @author: ����� 
	 * @date: 2021��1��19�� ����1:54:23
	 */
	public int updateUserPwd(String phone,String email,String password) {
		return userMapper.updateUserPwd(phone, email, password);
	}
	/**
	 * @Title: findUserByUserId
	 * @Description: ����IDֵ��ѯ�û���Ϣ
	 * @author: ����� 
	 * @date: 2021��1��18�� ����10:27:35
	 */
	public User findUserByUserId(Integer userId) {
		return userMapper.findUserByUserId(userId);
	}
	
	/**
	 * @Title: addUsers
	 * @Description: ����û�
	 * @author: ����� 
	 * @date: 2021��1��17�� ����3:47:35
	 */
	public int addUser(User user) {
		return userMapper.addUser(user);
	}
	
	/**
	 * @Title: updateMsgOfUser
	 * @Description: �����û���Ϣ
	 * @author: ����� 
	 * @date: 2021��1��17�� ����3:45:28
	 */
	public int updateMsgOfUser(User user) {
		return userMapper.updateMsgOfUser(user);
	}
	
	/**
	 * @Title: queryFollowed
	 * @Description: ��ѯ��ע�б�
	 * @author: ����� 
	 * @date: 2021��1��17�� ����3:44:19
	 */
	public List<User> findFollowed(Integer userId){
		return userMapper.findFollowed(userId);
	}
	
	/**
	 * @Title: findFans
	 * @Description: ��ѯ��˿�б�
	 * @author: ����� 
	 * @date: 2021��1��18�� ����10:20:14
	 */
	public List<User> findFans(Integer userId){
		return userMapper.findFans(userId);
	}
	
	/**
	 * @Title: findIfAttention
	 * @Description: ��ѯ�Ƿ��ע
	 * @author: ����� 
	 * @date: 2021��1��17�� ����4:11:38
	 */
	public int findIfAttention(Attention attention) {
		return userMapper.findIfAttention(attention);
	}
	
	/**
	 * @Title: addAttention
	 * @Description: ��ӹ�ע��Ŀ
	 * @author: ����� 
	 * @date: 2021��1��17�� ����4:12:02
	 */
	public int addAttention(Attention attention) {
		return userMapper.addAttention(attention);
	}
	
	/**
	 * @Title: deleteAttention
	 * @Description: ɾ����ע��Ϣ
	 * @author: ����� 
	 * @date: 2021��1��17�� ����4:12:16
	 */
	public int deleteAttention(Attention attention) {
		return userMapper.deleteAttention(attention);
	}
	
	/**
	 * @Title: findUserByName
	 * @Description: �����û�����ѯ�û�
	 * @author: ����� 
	 * @date: 2021��2��2�� ����11:53:31
	 */
	public User findUserByName(String userName){
		return userMapper.findUserByName(userName);
	}
	
	/**
	 * @Title: findAllUser
	 * @Description: ��ѯ�����û�
	 * @author: ����� 
	 * @date: 2021��2��2�� ����1:56:26
	 */
	public List<User> findAllUser(){
		return userMapper.findAllUser();
	}
	
	/**
	 * @Title: deleteUserById
	 * @Description: ɾ���û���Ϣ
	 * @author: ����� 
	 * @date: 2021��2��2�� ����7:48:53
	 */
	public int deleteUserById(Integer userId) {
		return userMapper.deleteUserById(userId);
	}
	
	/**
	 * @Title: findForPage
	 * @Description: ��ҳ��ѯ
	 * @author: ����� 
	 * @date: 2021��2��2�� ����7:55:28
	 */
	public List<User> findForPage(int startIndex, int pageSize){
		return userMapper.findForPage(startIndex, pageSize);
	}
	
	/**
	 * @Title: findCountUser
	 * @Description: ��ѯ�û�����
	 * @author: ����� 
	 * @date: 2021��2��2�� ����7:55:58
	 */
	public int findCountUser() {
		return userMapper.findCountUser();
	}
}
