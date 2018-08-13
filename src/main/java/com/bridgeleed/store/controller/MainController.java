package com.bridgeleed.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bridgeleed.store.bean.Goods;
import com.bridgeleed.store.bean.GoodsCategory;
import com.bridgeleed.store.service.GoodsService;
import com.bridgeleed.store.service.IGoodsCategoryService;
@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	private IGoodsCategoryService goodsCategoryService;
	@Resource
	private GoodsService goodsService;
	
	@RequestMapping("/showIndex.do")
	public String showIndex(ModelMap map){
		
		List<List<GoodsCategory>> list3 = new ArrayList<List<GoodsCategory>>();
		//调用业务层的方法
		List<GoodsCategory> list2 = goodsCategoryService.getByParentId(161, 0, 3);
		
		for (GoodsCategory goodsCategory : list2) {
			//得到三级分类
			list3.add(goodsCategoryService.getByParentId(goodsCategory.getId(), null, null));
			
		}
		//获取热卖商品
		List<Goods> goodsList = goodsService.getByCategoryId(163, 0, 3);
		
		map.addAttribute("list2",list2);
		map.addAttribute("list3",list3);
		
		//把热卖商品的集合添加到集合中
		map.addAttribute("goodsList", goodsList);
		
		return "index";
	}
	
	
	
	

}
