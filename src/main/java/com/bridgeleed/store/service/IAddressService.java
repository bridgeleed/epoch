package com.bridgeleed.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bridgeleed.store.bean.Address;
@Transactional
public interface IAddressService {
	/**
	 * �����ջ��˵�ַ
	 * @param address
	 */
	void addAddress(Address address);
	
	/**
	 * ����uid��ѯaddress
	 * @param uid
	 * @return
	 */
    List<Address> getByUid(Integer uid);
    //����Ĭ�ϵ�ַ
    void setDefalut(Integer uid,Integer id);
    Address getById(Integer id);
    
    //ҳ�����ݴ����־ò�
    void updateAddress(Address address);
    //ɾ���ջ���ַ
    void removeAddress(Integer id); 

}
