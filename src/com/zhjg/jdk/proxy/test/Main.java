package com.zhjg.jdk.proxy.test;

import com.zhjg.jdk.proxy.pojo.User;
import com.zhjg.jdk.proxy.proxy.LogProxy;
import com.zhjg.jdk.proxy.proxy.TransProxy;
import com.zhjg.jdk.proxy.service.LoginService;
import com.zhjg.jdk.proxy.service.MenuService;
import com.zhjg.jdk.proxy.service.UserService;
import com.zhjg.jdk.proxy.service.impl.LoginServiceImpl;
import com.zhjg.jdk.proxy.service.impl.MenuServiceImpl;
import com.zhjg.jdk.proxy.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		//一个代理类代理多种被代理类
		LogProxy loginProxy = new LogProxy();
		//为登录业务添加日志功能
        LoginService loginService = (LoginService)loginProxy.bind(new LoginServiceImpl());
        loginService.login();
        
		System.out.println();
		
		LogProxy userProxy = new LogProxy();
		//为用户业务组件的相关操作添加日志功能
        UserService userService = (UserService)userProxy.bind(new UserServiceImpl());
        User user = userService.getUserById(1);
        System.out.println(user.getId()+">"+user.getName()+">"+user.getAge());
        
        System.out.println();
        
        //一个被代理类被多个代理类代理
        LogProxy menuLogProxy = new LogProxy();  
        TransProxy menuTransProxy = new TransProxy();
        //为菜单业务组件的相关操作添加日志和事务功能
        MenuService menuService = (MenuService)menuLogProxy.bind(menuTransProxy.bind(new MenuServiceImpl()));
        menuService.insert();
        
        //只需无限开发代理类，被代理类可以无限制增强............
        
          
	}
}
