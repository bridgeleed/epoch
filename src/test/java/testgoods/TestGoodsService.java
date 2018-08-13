package testgoods;



import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgeleed.store.bean.Goods;
import com.bridgeleed.store.service.GoodsService;

public class TestGoodsService {
	@Test
	public void TestGoodsServiceselect(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
	
		GoodsService goodsService = ac.getBean("goodsService",GoodsService.class);
		List<Goods> list  = goodsService.getByCategoryId(163, 0, 3);
		System.out.println(list);
		ac.close();
		
	
	}

}
