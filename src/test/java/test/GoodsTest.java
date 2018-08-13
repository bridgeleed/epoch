package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgeleed.store.bean.GoodsCategory;
import com.bridgeleed.store.mapper.GoodsCategoryMapper;
import com.bridgeleed.store.service.GoodsCategoryService;

public class GoodsTest {
	
	@Test
	public void testGoodsSelect(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		GoodsCategoryMapper goodsCategoryMapper = ac.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
		
		List<GoodsCategory> list = goodsCategoryMapper.selectGoodsCategory(162, 0, 3);
		System.out.println(list);
		ac.close();
		
	}
	
	
	@Test
	public void testGoodsService(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		
		GoodsCategoryService goodsCategoryService = ac.getBean("goodsCategoryService",GoodsCategoryService.class);
		
		System.out.println(goodsCategoryService.getByParentId(161, 0, 3));
		ac.close();
		
	}

}
