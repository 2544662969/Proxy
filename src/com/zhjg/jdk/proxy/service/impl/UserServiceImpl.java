package com.zhjg.jdk.proxy.service.impl;

import com.zhjg.jdk.proxy.pojo.User;
import com.zhjg.jdk.proxy.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public User getUserById(int id) {
		System.out.println("sql begin");
		User user = new User();
		user.setId(id);
		user.setName("tom");
		user.setAge(20);
		System.out.println("sql end");
		return user;
	}

}
