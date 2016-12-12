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
		//����ִ�еķ��ؽ��
		Object result = null;
		//ǰ����ǿ
		System.out.println(".....before method invoke.....");
		//���ô�����ĸ��෽����Ҳ���Ǳ�������ķ���
		result = proxy.invokeSuper(obj, args);
		//������ǿ
		System.out.println("......after method invoke.....");
		//����ִ�н��
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public Object getProxy(Class clz){
		//���ô�����ĸ���Ϊ��������
		enhancer.setSuperclass(clz);
		//�Ե���
		enhancer.setCallback(this);
		//�����������
		return enhancer.create();
	}
	

}
