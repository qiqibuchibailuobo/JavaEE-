package edu.hhtc.jsj.dao;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAdvice implements MethodInterceptor{
	public static void check_Permissions(){
		System.out.println("模拟检查权限...");
	}
	public static void log(){
		System.out.println("模拟记录日志...");
	}
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// TODO Auto-generated method stub
		check_Permissions();
		Object obj = mi.proceed();
		log();
		
		return obj;
	}

}