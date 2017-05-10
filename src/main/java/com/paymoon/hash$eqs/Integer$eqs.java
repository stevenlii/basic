package com.paymoon.hash$eqs;

import java.util.HashMap;
/**
 * JDK 1.7
 * @author yol
 *
 * @param <K>
 * @param <V>
 */
public class Integer$eqs<K,V> extends HashMap<K, V>{
	public static void main(String[] args) {
		Integer i1 = 1;
		Integer i2 = 1;
		System.err.println(i1==i2);// true
		i1 = new Integer(1);
		i2 = new Integer(1);
		System.err.println(i1==i2);// false
		System.err.println(i1.equals(i2));// true
		System.err.println(i1.intValue()==i2);// true
		
	}
}
