package test;



import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestMd5 {
	

	
	@Test
	public  void testfile() throws Exception, IOException{
		String string = DigestUtils.md5Hex(new FileInputStream("pom.xml"));
		System.out.println(string);
		
	}
	
	@Test
	public void testSalt(){
		
		String string = "123456";
		String salt = "同志们辛苦了，你们很优秀，你们是祖国的花朵";
		System.out.println(DigestUtils.md5Hex(string+salt));
		System.out.println(DigestUtils.md5Hex(string));
		
		
	
	}

}
