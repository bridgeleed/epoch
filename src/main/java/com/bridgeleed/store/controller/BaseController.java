package com.bridgeleed.store.controller;

import javax.servlet.http.HttpSession;

import com.bridgeleed.store.bean.User;

public class BaseController {
	//��ȡ�û�id
	public Integer getId(HttpSession session){
		User user = (User)session.getAttribute("user");
		Integer id = null ;
		if(user!=null){
			id = user.getId();
		}
		return id;
		
	}

}
