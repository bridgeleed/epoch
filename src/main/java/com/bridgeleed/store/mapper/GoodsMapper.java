package com.bridgeleed.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bridgeleed.store.bean.Goods;


public interface GoodsMapper {
	List<Goods> selectByCategoryId(@Param("categoryId") Integer categoryId,
			                         @Param("offset") Integer offset,
			                         @Param("count") Integer count); 
	
	Integer selectCount(Integer categoryId);
	
	//查询商品详情
	Goods selectGoodsDetilById(String id);

}
