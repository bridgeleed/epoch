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

//�����ջ���ַ
	public void addAddress(Address address) {
		//1.��address�����recvDistrict��ֵ
		address.setRecvDistrict(getDistrict(address)); 
		
		//2.��address�����isDefault��ֵ
		Integer count = addressMapper.selectByUid(address.getUid()).size();
		if(count==0){
			address.setIsDefault(1);
		}else {
			address.setIsDefault(0);
		}
		
		addressMapper.insertAddress(address);
		
	}

	/**
	 * ����uid��ѯ
	 */
	public List<Address> getByUid(Integer uid) {
		
		return addressMapper.selectByUid(uid);
	}

	/*������һ�㶼��ҵ���
	 * (non-Javadoc)
	 * @see com.bridgeleed.store.service.IAddressService#setDefalut(java.lang.Integer, java.lang.Integer)
	 */
	public void setDefalut(Integer uid, Integer id) {
		Integer n1 = addressMapper.updateByUid(uid);
		if(n1==0){
			throw new RuntimeException("ͨ��uid�޸Ĵ���");
		}
		
		Integer n2 = addressMapper.updateById(id);
		if(n2==0){
			throw new RuntimeException("ͨ��id�޸Ĵ���");
		}
	}
	
	

	public Address getById(Integer id) {
		
		return addressMapper.selectById(id);
	}
	
	
	public void updateAddress(Address address) {
		
		   address.setRecvDistrict(getDistrict(address));
		
			addressMapper.updateAddressById(address);
		}
	
	
	//��District��װ��һ������
	
	private String getDistrict(Address address ){
		return dictMapper.selectByProvinceCode(address.getRecvProvince())+
                dictMapper.selectByCityCode(address.getRecvCity())+
                dictMapper.selectByAreaCode(address.getRecvArea());
	}
	
	
	//ɾ���ջ���ַ
	
	public void removeAddress(Integer id) {
			addressMapper.deleteAddressById(id);
			
		}

}
