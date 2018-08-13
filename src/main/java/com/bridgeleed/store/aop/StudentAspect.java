package com.bridgeleed.store.aop;

import org.springframework.stereotype.Component;
/**
 * 模拟前置通知
 * @author Super_man
 *
 */
@Component
public class StudentAspect {
	
	public void test1(){
		System.out.println("StudentAspect.test1()模拟前置通知");
	}

}
