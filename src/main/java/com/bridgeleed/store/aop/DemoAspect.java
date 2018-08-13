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
	//��ʾ��ҵ�񷽷�֮ǰִ��
	//"bean(userService)"��ʾ���е�bean��ΪuserService
	//userService��ʾSpringʵ������bean������
	@Before("bean(userService)")
	public void test1(){
		System.out.println("DemoAspect.test1()");
		
	}
	//������û���쳣��ִ��
	@After("bean(userService)")
	public void test2(){
		System.out.println("DemoAspect.test2()");
		
	}
	
	//�������쳣ʱִ��֪ͨ
	@AfterReturning("bean(userService)")
	public void test3(){
		System.out.println("DemoAspect.test3()");
		
	}
	//�����쳣ʱִ��֪ͨ
	@AfterThrowing("bean(userService)")
	public void test4(){
		System.out.println("DemoAspect.test4()");
		
	}
	
	//��ʾ����֪ͨ
	//1.�����з���ֵ������ֵ������ҵ���߼������ķ���ֵ����
	//2.�����в�����ProceedingJoinPoint (���ӵ�)
	//3.���뽫����ֵ������ ��Ȼû����ֵ��������
	@Around("bean(userService)")
	public Object test5(ProceedingJoinPoint pp) throws Throwable{
		long a = System.currentTimeMillis();
		System.out.println(a);
		//��ʾ����ҵ�񷽷�
		Object obj = pp.proceed();
		System.out.println(System.currentTimeMillis()-a);
		
		return obj;
	}
	
	@Around("execution(* com.bridgeleed.store.service.*Service.login(..))")
	public Object test6(ProceedingJoinPoint pp) throws Throwable{
		long a = System.currentTimeMillis();
		
		//��ʾ����ҵ�񷽷�
		Object obj = pp.proceed();
		System.out.println(System.currentTimeMillis()-a);
		System.out.println("11111111111111111111111111111111111111111");
		
		return obj;
	}
	
	
	
	

}
