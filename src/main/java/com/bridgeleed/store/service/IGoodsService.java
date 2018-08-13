package com.bridgeleed.store.service;

import java.util.List;

import com.bridgeleed.store.bean.Goods;

public interface IGoodsService {
	
	List<Goods> getByCategoryId(Integer category,Integer offset,Integer count);
	Integer getCount(Integer categoryId);
	
	
	//获取商品详情
	Goods getGoodsDetilById(String id);

}
