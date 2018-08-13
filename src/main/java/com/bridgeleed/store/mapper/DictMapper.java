package com.bridgeleed.store.mapper;

import java.util.List;

import com.bridgeleed.store.bean.Area;
import com.bridgeleed.store.bean.City;
import com.bridgeleed.store.bean.Province;

public interface DictMapper {
	List<Province> selectProvince();
	List<City> selectCity(String provinceCode);
	List<Area> selectArea(String cityCode);
	//ͨ��code��ѯʡ����������
	String selectByProvinceCode(String  provinceCode);
	String selectByCityCode(String  cityCode);
	String selectByAreaCode(String  areaCode);
	
	
	

}
