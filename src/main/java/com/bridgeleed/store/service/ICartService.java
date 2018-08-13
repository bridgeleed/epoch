package com.bridgeleed.store.service;

import java.util.List;

import com.bridgeleed.store.bean.Cart;
import com.bridgeleed.store.vo.CartVo;

public interface ICartService {
	void addCart(Cart cart);
	
	List<CartVo> getByUid(Integer uid);

}
