package testgoods;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgeleed.store.bean.Cart;
import com.bridgeleed.store.mapper.CartMapper;
import com.bridgeleed.store.mapper.GoodsMapper;
import com.bridgeleed.store.service.CartService;

public class TestselectGoodsById {
	
	@Test
	public void testGoodsDetil(){
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		
		GoodsMapper goodsMapper = ac.getBean("goodsMapper",GoodsMapper.class);
		
		System.out.println(goodsMapper.selectGoodsDetilById("10000000"));
		ac.close();
	}
	
	@Test
	public void testGoodsInsert(){
		AbstractApplicationContext ac =new ClassPathXmlApplicationContext("application-dao.xml");
		
		CartMapper cartMapper = ac.getBean("cartMapper",CartMapper.class);
		Cart cart = new Cart();
		cart.setUid(1);
		cart.setGoodsId("10000000");
		cart.setNum(6);
		cart.setCreatedUser("bridge");
		cart.setCreatedTime(new Date());
		cartMapper.insertCart(cart);
		ac.close();
	}
	
	
	
	
	

}
