package com.bridgeleed.store.aop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * 代理类的特点
 * 1.和目标类有共同的特点@Aspect
 * 2.同时拥有目标类的对象和切面类的对象
 * @author Super_man
 *
 */
@Component
public class StudentProxy implements IStudentService {
	@Resource
	private StudentService studentService;
	@Resource
	private StudentAspect studentAspect;
	
	

	public void add() {
		//模拟前置通知 按照规定的顺序进行调用方法
	    studentAspect.test1();
		studentService.add();
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public void get() {
		// TODO Auto-generated method stub
		
	}

	public void getAll() {
		// TODO Auto-generated method stub
		
	}

}
