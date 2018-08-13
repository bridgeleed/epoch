package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgeleed.store.bean.Address;
import com.bridgeleed.store.mapper.AddressMapper;
import com.bridgeleed.store.mapper.DictMapper;
import com.bridgeleed.store.service.AddressService;
import com.bridgeleed.store.service.IAddressService;

public class TestAddress {
	
	@Test
	public void testMapper(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		
		AddressMapper addressMapper = ac.getBean("addressMapper",AddressMapper.class);
		
		Address address = new Address();
		address.setUid(2);
		address.setRecvName("admin");
		address.setRecvProvince("130000");
		addressMapper.insertAddress(address);
		ac.close();
	}
	
	@Test
	public void  addresssAll(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		DictMapper dictMapper = ac.getBean("dictMapper",DictMapper.class);
		
		System.out.println(dictMapper.selectByProvinceCode("130000"));
		System.out.println(dictMapper.selectByCityCode("130900"));
		System.out.println(dictMapper.selectByAreaCode("110102"));
		ac.close();
		
	}
	
	@Test
	public void  addresss11(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		AddressMapper addressMapper = ac.getBean("addressMapper",AddressMapper.class);
		List<Address> addresses = addressMapper.selectByUid(2);
		System.out.println(addresses);
		
		IAddressService addressService = ac.getBean("addressService",IAddressService.class);
		
		Address address = new Address();
		
		address.setCreatedUser("师宝辉");
		address.setUid(3);
		addressService.addAddress(address);
		
		ac.close();
		
	}
	
	@Test
	public void testSetDefault(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		AddressService service = ac.getBean("addressService",AddressService.class);
		service.setDefalut(2, 2);
		ac.close();
		
		
	}
	@Test
	public void testAddressById(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		AddressMapper addressMapper= ac.getBean("addressMapper",AddressMapper.class);
		Address address = addressMapper.selectById(2);
		System.out.println(address);
		ac.close();
		
	}
	
	@Test
	public void testupdateAddressById(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		AddressMapper addressMapper= ac.getBean("addressMapper",AddressMapper.class);
		Address address = new Address();
		address.setId(1);        
		address.setRecvName("bridgeleed");
		address.setRecvPhone("15222063039");
		address.setRecvProvince("620000");
		address.setRecvDistrict("甘肃省陇南市礼县");
		address.setRecvTag("欣欣嘉园");
		address.setRecvZip("742201");
		address.setRecvArea("礼县");
		address.setRecvCity("陇南市");
		address.setRecvTel("10086");
		address.setRecvAddress("108");
		
	    addressMapper.updateAddressById(address);
		
		ac.close();
		
	}
	
	
	@Test
	public void testupdateAddress(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		AddressService addressService= ac.getBean("addressService",AddressService.class);
		Address address = new Address();
		address.setId(1);        
		address.setRecvName("bridgeleed");
		address.setRecvPhone("15222063039");
		address.setRecvProvince("130000");
		address.setRecvDistrict("河北省邯郸市邯郸县");
		address.setRecvTag("欣欣嘉园");
		address.setRecvZip("742201");
		address.setRecvArea("邯郸县");
		address.setRecvCity("邯郸市");
		address.setRecvTel("10086");
		address.setRecvAddress("108");
		
	    addressService.updateAddress(address);
		
		ac.close();
		
	}
	
	
	@Test
	public void removeAddressTest(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		
		AddressService addressService = ac.getBean("addressService",AddressService.class);
		addressService.removeAddress(3);
		ac.close();
				
	}
	
	
	
	
	

}
