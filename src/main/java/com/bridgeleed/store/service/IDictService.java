package com.bridgeleed.store.service;

import java.util.List;

import com.bridgeleed.store.bean.Area;
import com.bridgeleed.store.bean.City;
import com.bridgeleed.store.bean.Province;

public interface IDictService {
	/**
	 * 获取省份
	 * @return
	 */
	 
	List<Province> getProvince();
	/**
	 * 获取省对应的城市
	 * @param provinceCode
	 * @return
	 */
	
	List<City> getCity(String provinceCode);
	
	List<Area> getArea(String cityCode);

}
