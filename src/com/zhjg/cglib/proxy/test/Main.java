package com.zhjg.cglib.proxy.test;

import com.zhjg.cglib.proxy.pojo.Person;
import com.zhjg.cglib.proxy.proxy.CglibProxy;

public class Main {

	public static void main(String[] args) {
		
		//�����๤��
		CglibProxy proxy = new CglibProxy();
		//�����������
		Person person = (Person)proxy.getProxy(Person.class);
		//ִ�д������ķ���
		person.sleep();
          
	}
}
