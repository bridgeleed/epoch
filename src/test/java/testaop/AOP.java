package testaop;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.bridgeleed.store.aop.IStudentService;
import com.bridgeleed.store.aop.StudentProxy;
import com.bridgeleed.store.aop.StudentProxyHandle;

public class AOP {
	@Test
	public void testProxy(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-aop.xml");
		
		IStudentService  proxy = ac.getBean("studentProxy",StudentProxy.class);
		proxy.add();
		ac.close();
		
	}
	
	@Test
	public void testProxyhandler(){
AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-aop.xml");
		
		StudentProxyHandle  proxy = ac.getBean("studentProxyHandle",StudentProxyHandle.class);
	    IStudentService service = (IStudentService)proxy.getProxyObject();
	    System.out.println(service.getClass());
	    service.add();
	    ac.close();
	   
	   
	}
	 

}
