package com.bridgeleed.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bridgeleed.store.bean.GoodsCategory;

public interface GoodsCategoryMapper {
	//查询二级和三级分类
	List<GoodsCategory> selectGoodsCategory(
										@Param("parentId")Integer parentId,
										@Param("offset")Integer offset,
										@Param("count")Integer count);

}
