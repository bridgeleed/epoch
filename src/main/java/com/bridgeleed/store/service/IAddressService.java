package com.bridgeleed.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bridgeleed.store.bean.Address;
@Transactional
public interface IAddressService {
	/**
	 * 增加收货人地址
	 * @param address
	 */
	void addAddress(Address address);
	
	/**
	 * 根据uid查询address
	 * @param uid
	 * @return
	 */
    List<Address> getByUid(Integer uid);
    //设置默认地址
    void setDefalut(Integer uid,Integer id);
    Address getById(Integer id);
    
    //页面数据传给持久层
    void updateAddress(Address address);
    //删除收货地址
    void removeAddress(Integer id); 

}
