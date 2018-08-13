package com.bridgeleed.store.mapper;
import org.apache.ibatis.annotations.Param;

import com.bridgeleed.store.bean.User;

/**
 * �־ò����
 * @author Super_man
 *
 */
public interface UserMapper {
	/**
	 * 
	 * @param user
	 * �����û�
	 * 
	 */
	void insertUser(User user);
	/**
	 * �����û������в�ѯ
	 * @return �����ѯ���ˣ��ѽ����ס��User���󷵻أ����û��ѯ������null
	 * 
	 */
	User selectByUsername(String username);
	/**
	 * �ж������Ψһ��
	 * @param email
	 * @return
	 */
	Integer selectByEmail(String email);
	
	Integer selectByPhone(String phone);
	
	//���ĸ�����Ϣ
	void updateUser(User user);
	//�����б�Ĳ�����������ʱ ��ע����д���
	void updateImage(@Param("id")Integer id,@Param("image")String image);	
	//ͨ��id��ѯ
	User selectUserById(Integer id);
	
	
	
	
	

}
