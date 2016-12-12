package com.zhjg.jdk.proxy.proxy;

/**
 * @author 327084
 * <p>事务代理类</p>
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransProxy implements InvocationHandler {

	private Object target;

	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object arg0, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		System.out.println("trans begin...........");
		result = method.invoke(target, args);
		System.out.println("trans end..............");
		return result;
	}

}
