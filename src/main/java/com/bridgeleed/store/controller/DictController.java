package com.bridgeleed.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bridgeleed.store.bean.Area;
import com.bridgeleed.store.bean.City;
import com.bridgeleed.store.bean.Province;
import com.bridgeleed.store.bean.ResponseResult;
import com.bridgeleed.store.service.DictService;

@Controller
@RequestMapping("/dict")
public class DictController {
	@Resource
	private DictService dictService;
	
	//��ȡʡ����Ϣ
	@RequestMapping("/getProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>> getProvince(){
		ResponseResult<List<Province>> rr = new ResponseResult<List<Province>>(1,"�ɹ�");
		List<Province> Provinces = dictService.getProvince();
		rr.setData(Provinces);
		return rr; 
	}
	
	//��ȡ������Ϣ
		@RequestMapping("/getCity.do")
		@ResponseBody
		public ResponseResult<List<City>> getCity(String provinceCode){
			ResponseResult<List<City>> rr = new ResponseResult<List<City>>(1,"�ɹ�");
			List<City> cities = dictService.getCity(provinceCode);
			rr.setData(cities);
			return rr;
			
		}
		
		//��ȡ�����ó�����Ϣ
		@RequestMapping("getArea.do")
		@ResponseBody
		public ResponseResult<List<Area>> getArea(String cityCode){
			
			ResponseResult<List<Area>> rr = new ResponseResult<List<Area>>(1,"�ɹ�"); 
			List<Area> areas = dictService.getArea(cityCode);
			rr.setData(areas);
			return rr;
		}
	

}
