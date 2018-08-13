package com.bridgeleed.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bridgeleed.store.bean.Cart;
import com.bridgeleed.store.mapper.CartMapper;
import com.bridgeleed.store.vo.CartVo;
@Service
public class CartService implements ICartService {
	@Resource
	private CartMapper cartMapper;

	public void addCart(Cart cart) {
		cartMapper.insertCart(cart);
		
	}

	public List<CartVo> getByUid(Integer uid) {
		
		return cartMapper.selectByUid(uid);
	}

}
