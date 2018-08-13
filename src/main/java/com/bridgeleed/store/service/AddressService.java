package com.bridgeleed.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bridgeleed.store.bean.Address;
import com.bridgeleed.store.mapper.AddressMapper;
import com.bridgeleed.store.mapper.DictMapper;
@Service
public class AddressService implements IAddressService {
@Resource
  private AddressMapper addressMapper;
@Resource
  private DictMapper dictMapper;

//增加收货地址
	public void addAddress(Address address) {
		//1.给address对象的recvDistrict赋值
		address.setRecvDistrict(getDistrict(address)); 
		
		//2.给address对象的isDefault赋值
		Integer count = addressMapper.selectByUid(address.getUid()).size();
		if(count==0){
			address.setIsDefault(1);
		}else {
			address.setIsDefault(0);
		}
		
		addressMapper.insertAddress(address);
		
	}

	/**
	 * 根据uid查询
	 */
	public List<Address> getByUid(Integer uid) {
		
		return addressMapper.selectByUid(uid);
	}

	/*事务处理一般都在业务层
	 * (non-Javadoc)
	 * @see com.bridgeleed.store.service.IAddressService#setDefalut(java.lang.Integer, java.lang.Integer)
	 */
	public void setDefalut(Integer uid, Integer id) {
		Integer n1 = addressMapper.updateByUid(uid);
		if(n1==0){
			throw new RuntimeException("通过uid修改错误");
		}
		
		Integer n2 = addressMapper.updateById(id);
		if(n2==0){
			throw new RuntimeException("通过id修改错误");
		}
	}
	
	

	public Address getById(Integer id) {
		
		return addressMapper.selectById(id);
	}
	
	
	public void updateAddress(Address address) {
		
		   address.setRecvDistrict(getDistrict(address));
		
			addressMapper.updateAddressById(address);
		}
	
	
	//将District封装成一个方法
	
	private String getDistrict(Address address ){
		return dictMapper.selectByProvinceCode(address.getRecvProvince())+
                dictMapper.selectByCityCode(address.getRecvCity())+
                dictMapper.selectByAreaCode(address.getRecvArea());
	}
	
	
	//删除收货地址
	
	public void removeAddress(Integer id) {
			addressMapper.deleteAddressById(id);
			
		}

}
