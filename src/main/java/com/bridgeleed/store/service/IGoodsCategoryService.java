package com.bridgeleed.store.service;

import java.util.List;

import com.bridgeleed.store.bean.GoodsCategory;

public interface IGoodsCategoryService {
	
	List<GoodsCategory> getByParentId(Integer ParentId,Integer offset,Integer count);

}
