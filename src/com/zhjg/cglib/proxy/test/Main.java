package com.zhjg.cglib.proxy.test;

import com.zhjg.cglib.proxy.pojo.Person;
import com.zhjg.cglib.proxy.proxy.CglibProxy;

public class Main {

	public static void main(String[] args) {
		
		//代理类工厂
		CglibProxy proxy = new CglibProxy();
		//创建代理对象
		Person person = (Person)proxy.getProxy(Person.class);
		//执行代理对象的方法
		person.sleep();
          
	}
}
