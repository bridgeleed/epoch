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
	
	//获取代理类的对象
	public Object getProxyObject(){
		//第一个参数表示：表示目标类的类加载器对象
		//第二个参数表示：表示目标类的接口类型
		//第三个参数表示：表示实现了的接口InvocationHandler的实现类对象
		return Proxy.newProxyInstance(studentService.getClass().getClassLoader(),
				studentService.getClass().getInterfaces(), this);
	}
    //实现目标类的方法
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//前置通知
		
		studentAspect.test1();
		//调用目标类的方法
		Object obj = method.invoke(studentService, args);
		return obj;
	}



}
