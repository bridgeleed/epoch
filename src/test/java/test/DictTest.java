package test;

import java.util.List;


import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgeleed.store.bean.City;
import com.bridgeleed.store.bean.Province;
import com.bridgeleed.store.mapper.DictMapper;


public class DictTest {
	@Test
	public void testDictMapper(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml"); 
		DictMapper dict = ac.getBean("dictMapper",DictMapper.class);
		System.out.println(222222);
		List<Province> list = dict.selectProvince();
		System.out.println(1111);
		System.out.println(list);
		ac.close();
		
	}
	
	@Test
	public void testCitySelect(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		
		DictMapper dictMapper = ac.getBean("dictMapper",DictMapper.class);
	 List<City> cities = dictMapper.selectCity("620000");
	 for(City city:cities){
		 System.out.println(city.getCityName());
	 }
		
		
		ac.close();
		
		
	}

}
