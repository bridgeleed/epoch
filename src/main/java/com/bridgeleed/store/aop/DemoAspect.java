package com.bridgeleed.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspect {
	//表示在业务方法之前执行
	//"bean(userService)"表示横切的bean类为userService
	//userService表示Spring实例化的bean的名称
	@Before("bean(userService)")
	public void test1(){
		System.out.println("DemoAspect.test1()");
		
	}
	//不管有没有异常都执行
	@After("bean(userService)")
	public void test2(){
		System.out.println("DemoAspect.test2()");
		
	}
	
	//不发生异常时执行通知
	@AfterReturning("bean(userService)")
	public void test3(){
		System.out.println("DemoAspect.test3()");
		
	}
	//发生异常时执行通知
	@AfterThrowing("bean(userService)")
	public void test4(){
		System.out.println("DemoAspect.test4()");
		
	}
	
	//表示环绕通知
	//1.必须有返回值：返回值类型是业务逻辑方法的返回值类型
	//2.必须有参数：ProceedingJoinPoint (连接点)
	//3.必须将返回值返回来 不然没法将值给控制器
	@Around("bean(userService)")
	public Object test5(ProceedingJoinPoint pp) throws Throwable{
		long a = System.currentTimeMillis();
		System.out.println(a);
		//表示调用业务方法
		Object obj = pp.proceed();
		System.out.println(System.currentTimeMillis()-a);
		
		return obj;
	}
	
	@Around("execution(* com.bridgeleed.store.service.*Service.login(..))")
	public Object test6(ProceedingJoinPoint pp) throws Throwable{
		long a = System.currentTimeMillis();
		
		//表示调用业务方法
		Object obj = pp.proceed();
		System.out.println(System.currentTimeMillis()-a);
		System.out.println("11111111111111111111111111111111111111111");
		
		return obj;
	}
	
	
	
	

}
