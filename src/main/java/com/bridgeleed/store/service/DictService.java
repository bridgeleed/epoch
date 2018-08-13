package com.bridgeleed.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bridgeleed.store.bean.Area;
import com.bridgeleed.store.bean.City;
import com.bridgeleed.store.bean.Province;
import com.bridgeleed.store.mapper.DictMapper;


@Service
public class DictService implements IDictService{
	@Resource
	private DictMapper dictMapper;

	public List<Province> getProvince() {
		return dictMapper.selectProvince();
	}

	public List<City> getCity(String provinceCode) {
		return dictMapper.selectCity(provinceCode);
	}

	public List<Area> getArea(String cityCode) {
		
		return dictMapper.selectArea(cityCode);
	}
	
	
	
	
	

}
