package com.bridgeleed.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bridgeleed.store.bean.GoodsCategory;
import com.bridgeleed.store.mapper.GoodsCategoryMapper;

@Service
public class GoodsCategoryService implements IGoodsCategoryService {
	@Resource
	private GoodsCategoryMapper goodsCategoryMapper;

	public List<GoodsCategory> getByParentId(Integer parentId, Integer offset, Integer count) {
		
		return goodsCategoryMapper.selectGoodsCategory(parentId, offset, count);
	}
	
	
	
	

}
