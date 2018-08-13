package com.bridgeleed.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bridgeleed.store.bean.Goods;
import com.bridgeleed.store.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	private GoodsService goodsService;
	/**
	 * 
	 * @param categoryId
	 * @param page
	 * @param map
	 * @return
	 * 调整参数列表
	 */
	@RequestMapping("/showSearch.do")
	public String showSearch(Integer categoryId,Integer page,ModelMap map){
		//三级分类的点击事件
		if (page==null) {
			page = 1;
		}
		//通过page计算出偏移量offset
		Integer offset = (page-1)*12;
		//获取每一页的商品的集合
		List<Goods> list = goodsService.getByCategoryId(categoryId,offset , 12);
		//把集合添加到map中
		map.addAttribute("list",list);
		//获取商品的数量
		Integer count = goodsService.getCount(categoryId);
		
		//显示共有多少页
		Integer pageSize = count%12==0?count/12:count/12+1;
		//把商品的数量添加到map中
		map.addAttribute("count",count);
		map.addAttribute("pageSize", pageSize);
		//把category传给页面
		map.addAttribute("categoryId",categoryId);
		//把当前页设置添加到map中
		map.addAttribute("currentPage",page);
		return "search";
	}
	
	//控制详情页面
	@RequestMapping("/showProductDetails.do")
	public String showProductDetails(String id,ModelMap map){
		Goods goods = goodsService.getGoodsDetilById(id);
		map.addAttribute("goods", goods);
		return "product_details";
	}
    	

}
