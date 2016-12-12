package com.zhjg.jdk.proxy.proxy;

/**
 * @author 327084
 * <p>日志代理类</p>
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogProxy implements InvocationHandler{

	//被代理对象(使用Object类型可以对所有类型进行代理)
	private Object target; 
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//方法返回结果
		Object result = null;
		//执行前
		System.out.println(".....start time...........");
		// 执行被代理对象的方法
		result = method.invoke(target, args);
		//执行后
		System.out.println(".....end time...........");
		return result;
	}

	/**
	 * 绑定被代理对象并返回代理对象的实例
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Object bind(Object target){
		this.target = target;
		//被代理对象的类加载器
		ClassLoader loader = target.getClass().getClassLoader();
		//被代理对象实现的接口
		Class[] inters = target.getClass().getInterfaces();
		return Proxy.newProxyInstance(loader, inters, this);
		
	}
}
