package com.zhjg.jdk.proxy.proxy;

/**
 * @author 327084
 * <p>��־������</p>
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogProxy implements InvocationHandler{

	//���������(ʹ��Object���Ϳ��Զ��������ͽ��д���)
	private Object target; 
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//�������ؽ��
		Object result = null;
		//ִ��ǰ
		System.out.println(".....start time...........");
		// ִ�б��������ķ���
		result = method.invoke(target, args);
		//ִ�к�
		System.out.println(".....end time...........");
		return result;
	}

	/**
	 * �󶨱�������󲢷��ش�������ʵ��
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Object bind(Object target){
		this.target = target;
		//�����������������
		ClassLoader loader = target.getClass().getClassLoader();
		//���������ʵ�ֵĽӿ�
		Class[] inters = target.getClass().getInterfaces();
		return Proxy.newProxyInstance(loader, inters, this);
		
	}
}
