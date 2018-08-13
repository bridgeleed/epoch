package cart;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgeleed.store.mapper.CartMapper;
import com.bridgeleed.store.vo.CartVo;

public class CartTest {
	
	@Test
	public void testCartSelect(){
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		
		CartMapper cartMapper = ac.getBean("cartMapper",CartMapper.class);
		
		List<CartVo> list = cartMapper.selectByUid(2);
		System.out.println(list);
		ac.close();
	}

}
