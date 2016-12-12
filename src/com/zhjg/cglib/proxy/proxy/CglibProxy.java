package com.zhjg.cglib.proxy.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	
	private Enhancer enhancer = new Enhancer();

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		//方法执行的返回结果
		Object result = null;
		//前置增强
		System.out.println(".....before method invoke.....");
		//调用代理类的父类方法，也就是被代理类的方法
		result = proxy.invokeSuper(obj, args);
		//后置增强
		System.out.println("......after method invoke.....");
		//返回执行结果
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public Object getProxy(Class clz){
		//设置代理类的父类为被代理类
		enhancer.setSuperclass(clz);
		//自调用
		enhancer.setCallback(this);
		//创建代理对象
		return enhancer.create();
	}
	

}
