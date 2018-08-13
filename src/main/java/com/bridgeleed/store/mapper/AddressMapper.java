package com.bridgeleed.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import com.bridgeleed.store.bean.Address;

public interface AddressMapper {
	 void insertAddress(Address address);
	 /**
	  * 查询用户的收获地址
	  * @param uid
	  * @return
	  */
	 List<Address> selectByUid(Integer uid);
	 
	 //
	 Integer updateByUid(Integer uid);
	 
	 Integer updateById(Integer id);
	 
	 Address selectById(Integer id);
	 
	 void updateAddressById(Address address);
	 
	 void deleteAddressById(Integer id); 

}
