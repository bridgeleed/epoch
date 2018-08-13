package com.bridgeleed.store.aop;


import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

	public void add() {
		System.out.println("StudentService.add()");
		
	}

	public void update() {
		System.out.println("StudentService.update()");
		
	}

	public void delete() {
		System.out.println("StudentService.delete()");
		
	}

	public void get() {
		System.out.println("StudentService.get()");
		
	}

	public void getAll() {
		System.out.println("StudentService.getAll()");
		
	}

}
