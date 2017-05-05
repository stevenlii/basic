package com.tgb.proxy;

import java.lang.reflect.Method;

import com.paymoon.basic.util.DateUtil;

public class TimeHandler  implements InvocationHandler {
	private Object target;

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {
		System.out.println("开始时间....." + DateUtil.getTime2Str(System.currentTimeMillis()));
		try {
			//java反射机制详解 及 Method.invoke解释 
			//http://azrael6619.iteye.com/blog/429797
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("结束时间....." + DateUtil.getTime2Str(System.currentTimeMillis()));
	}
}
