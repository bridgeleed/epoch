package com.bridgeleed.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bridgeleed.store.bean.Cart;
import com.bridgeleed.store.bean.ResponseResult;
import com.bridgeleed.store.service.CartService;
import com.bridgeleed.store.vo.CartVo;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {
	@Resource
	private CartService cartService;
	
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(HttpSession session,String goodsId,Integer num){
		
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"成功");
		Cart cart = new Cart();
		cart.setUid(this.getId(session));
		cart.setNum(num);
		cart.setGoodsId(goodsId);
		cartService.addCart(cart);
		return rr;
		
	}
	
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,ModelMap map){
		List<CartVo> list = cartService.getByUid(this.getId(session));
		//把list添加到map中
		map.addAttribute("listVo",list);
		
		return "cart";
	}
	
	

}
