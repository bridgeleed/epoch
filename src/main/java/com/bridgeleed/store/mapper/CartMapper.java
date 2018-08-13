package com.bridgeleed.store.mapper;


import java.util.List;

import com.bridgeleed.store.bean.Cart;
import com.bridgeleed.store.vo.CartVo;

public interface CartMapper {
	
	//插入一个购物车商品
	void insertCart(Cart cart);
	//
	List<CartVo> selectByUid(Integer uid);

}
