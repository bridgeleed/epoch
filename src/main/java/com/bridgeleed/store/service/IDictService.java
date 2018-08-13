package com.bridgeleed.store.service;

import java.util.List;

import com.bridgeleed.store.bean.Area;
import com.bridgeleed.store.bean.City;
import com.bridgeleed.store.bean.Province;

public interface IDictService {
	/**
	 * ��ȡʡ��
	 * @return
	 */
	 
	List<Province> getProvince();
	/**
	 * ��ȡʡ��Ӧ�ĳ���
	 * @param provinceCode
	 * @return
	 */
	
	List<City> getCity(String provinceCode);
	
	List<Area> getArea(String cityCode);

}
