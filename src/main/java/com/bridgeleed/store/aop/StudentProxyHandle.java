package com.bridgeleed.store.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class StudentProxyHandle  implements InvocationHandler{
	@Resource
	private StudentService studentService;
	@Resource
	private StudentAspect studentAspect;
	
	//��ȡ������Ķ���
	public Object getProxyObject(){
		//��һ��������ʾ����ʾĿ����������������
		//�ڶ���������ʾ����ʾĿ����Ľӿ�����
		//������������ʾ����ʾʵ���˵Ľӿ�InvocationHandler��ʵ�������
		return Proxy.newProxyInstance(studentService.getClass().getClassLoader(),
				studentService.getClass().getInterfaces(), this);
	}
    //ʵ��Ŀ����ķ���
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//ǰ��֪ͨ
		
		studentAspect.test1();
		//����Ŀ����ķ���
		Object obj = method.invoke(studentService, args);
		return obj;
	}



}
