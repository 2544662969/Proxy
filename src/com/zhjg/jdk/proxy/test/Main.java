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
		
		//һ�������������ֱ�������
		LogProxy loginProxy = new LogProxy();
		//Ϊ��¼ҵ�������־����
        LoginService loginService = (LoginService)loginProxy.bind(new LoginServiceImpl());
        loginService.login();
        
		System.out.println();
		
		LogProxy userProxy = new LogProxy();
		//Ϊ�û�ҵ���������ز��������־����
        UserService userService = (UserService)userProxy.bind(new UserServiceImpl());
        User user = userService.getUserById(1);
        System.out.println(user.getId()+">"+user.getName()+">"+user.getAge());
        
        System.out.println();
        
        //һ���������౻������������
        LogProxy menuLogProxy = new LogProxy();  
        TransProxy menuTransProxy = new TransProxy();
        //Ϊ�˵�ҵ���������ز��������־��������
        MenuService menuService = (MenuService)menuLogProxy.bind(menuTransProxy.bind(new MenuServiceImpl()));
        menuService.insert();
        
        //ֻ�����޿��������࣬�������������������ǿ............
        
          
	}
}
