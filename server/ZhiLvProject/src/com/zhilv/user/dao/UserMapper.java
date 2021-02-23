package com.zhilv.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhilv.entity.Attention;
import com.zhilv.entity.User;


/**   
 * @ClassName: UserMapper   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��17�� ����3:37:13       
 */
public interface UserMapper {

	/**
	 * @Title: findUserByPhone
	 * @Description: ��ѯ�û���Ϣ�������䡢�绰������
	 * @author: ����� 
	 * @date: 2021��1��17�� ����3:47:13
	 */
	public User findUserByPhoneAndEmail(@Param("phone")String phone,@Param("email")String email, @Param("password")String password);
	
	/**
	 * @Title: findUserByUserId
	 * @Description: ����IDֵ��ѯ�û���Ϣ
	 * @author: ����� 
	 * @date: 2021��1��18�� ����10:27:35
	 */
	public User findUserByUserId(@Param("userId")Integer userId);
	
	/**
	 * @Title: updateUserPwd
	 * @Description: ��������
	 * @author: ����� 
	 * @date: 2021��1��19�� ����1:54:23
	 */
	public int updateUserPwd(@Param("phone")String phone,@Param("email")String email, @Param("password")String password);
	
	/**
	 * @Title: addUsers
	 * @Description: ����û�
	 * @author: ����� 
	 * @date: 2021��1��17�� ����3:47:35
	 */
	public int addUser(@Param("user")User user);
	
	/**
	 * @Title: updateMsgOfUser
	 * @Description: �����û���Ϣ
	 * @author: ����� 
	 * @date: 2021��1��17�� ����3:45:28
	 */
	public int updateMsgOfUser(@Param("user")User user);

	
	/**
	 * @Title: queryFollowed
	 * @Description: ��ѯ��ע�б�
	 * @author: ����� 
	 * @date: 2021��1��17�� ����3:44:19
	 */
	public List<User> findFollowed(@Param("userId")Integer userId);
	
	/**
	 * @Title: findFans
	 * @Description: ��ѯ��˿�б�
	 * @author: ����� 
	 * @date: 2021��1��18�� ����10:20:14
	 */
	public List<User> findFans(@Param("userId")Integer userId);
	
	/**
	 * @Title: findIfAttention
	 * @Description: ��ѯ�Ƿ��ע
	 * @author: ����� 
	 * @date: 2021��1��17�� ����4:11:38
	 */
	public int findIfAttention(@Param("attention")Attention attention);
	
	/**
	 * @Title: addAttention
	 * @Description: ��ӹ�ע��Ŀ
	 * @author: ����� 
	 * @date: 2021��1��17�� ����4:12:02
	 */
	public int addAttention(@Param("attention")Attention attention);
	
	/**
	 * @Title: deleteAttention
	 * @Description: ɾ����ע��Ϣ
	 * @author: ����� 
	 * @date: 2021��1��17�� ����4:12:16
	 */
	public int deleteAttention(@Param("attention")Attention attention);
	
	/**
	 * @Title: findUserByName
	 * @Description: �����û�����ѯ�û�
	 * @author: ����� 
	 * @date: 2021��2��2�� ����11:53:31
	 */
	public List<User> findUserByName(String userName);
	
	/**
	 * @Title: findAllUser
	 * @Description: ��ѯ�����û�
	 * @author: ����� 
	 * @date: 2021��2��2�� ����1:56:26
	 */
	public List<User> findAllUser();
	
	/**
	 * @Title: deleteUserById
	 * @Description: ɾ���û���Ϣ
	 * @author: ����� 
	 * @date: 2021��2��2�� ����7:48:53
	 */
	public int deleteUserById(Integer userId);

	/**
	 * @Title: findForPage
	 * @Description: ��ҳ��ѯ
	 * @author: ����� 
	 * @date: 2021��2��2�� ����7:55:28
	 */
	public List<User> findForPage(@Param("userName")String userName,@Param("start")int startIndex, @Param("size")int pageSize);
	
	/**
	 * @Title: findCountUser
	 * @Description: ��ѯ�û�����
	 * @author: ����� 
	 * @date: 2021��2��2�� ����7:55:58
	 */
	public int findCountUser(String userName);
}
