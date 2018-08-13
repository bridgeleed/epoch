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
	 * ���������б�
	 */
	@RequestMapping("/showSearch.do")
	public String showSearch(Integer categoryId,Integer page,ModelMap map){
		//��������ĵ���¼�
		if (page==null) {
			page = 1;
		}
		//ͨ��page�����ƫ����offset
		Integer offset = (page-1)*12;
		//��ȡÿһҳ����Ʒ�ļ���
		List<Goods> list = goodsService.getByCategoryId(categoryId,offset , 12);
		//�Ѽ�����ӵ�map��
		map.addAttribute("list",list);
		//��ȡ��Ʒ������
		Integer count = goodsService.getCount(categoryId);
		
		//��ʾ���ж���ҳ
		Integer pageSize = count%12==0?count/12:count/12+1;
		//����Ʒ��������ӵ�map��
		map.addAttribute("count",count);
		map.addAttribute("pageSize", pageSize);
		//��category����ҳ��
		map.addAttribute("categoryId",categoryId);
		//�ѵ�ǰҳ������ӵ�map��
		map.addAttribute("currentPage",page);
		return "search";
	}
	
	//��������ҳ��
	@RequestMapping("/showProductDetails.do")
	public String showProductDetails(String id,ModelMap map){
		Goods goods = goodsService.getGoodsDetilById(id);
		map.addAttribute("goods", goods);
		return "product_details";
	}
    	

}
