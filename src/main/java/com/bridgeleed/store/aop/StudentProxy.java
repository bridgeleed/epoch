package com.bridgeleed.store.aop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * ��������ص�
 * 1.��Ŀ�����й�ͬ���ص�@Aspect
 * 2.ͬʱӵ��Ŀ����Ķ����������Ķ���
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
		//ģ��ǰ��֪ͨ ���չ涨��˳����е��÷���
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
