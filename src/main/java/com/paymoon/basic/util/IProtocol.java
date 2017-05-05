package com.paymoon.basic.util;

import java.util.Map;

/**
 * @author lizhiqiang
 * desc 各种协议的实现的原子方法, 用以工具类的调用
 *
 */
public interface IProtocol {
	
	public Map<String, String> client(Map<String, String> map);
}
