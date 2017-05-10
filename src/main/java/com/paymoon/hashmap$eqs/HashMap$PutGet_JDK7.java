package com.paymoon.hashmap$eqs;

import java.util.HashMap;
/**
 * JDK 1.7
 * @author yol
 *
 * @param <K>
 * @param <V>
 */
public class HashMap$PutGet_JDK7<K,V> extends HashMap<K, V>{
	/**
	 * haspmap jdk7.0的put方法
	 * 主要逻辑
	 * 1、先查询，无则插入，有则覆盖
	 * 代码逻辑
	 * 1、对要放入的key进行hash,以用来查询（重要：是对key hash不是V）,
	 * 并通过key的hash，用indexFor方法获得当前hash在数组中的索引
	 * 2、e.hash == hash,e是Entry对象，e.hash应该就是e.key.hash,对比hash和eqs（key），判断是否
	 * 存在当前key
	 * 3、如果存在，则覆盖旧值并返回旧值，如果不存在，则addEntry(hash, key, value, i)
	 * 4、addEntry里面的方法：table[bucketIndex] = new Entry<>(hash, key, value, e);可以看出来是加了
	 * Entry对象
	 * 
	 */
	
//	 public V put(K key, V value) {
//	        if (table == EMPTY_TABLE) {
//	            inflateTable(threshold);
//	        }
//	        if (key == null)
//	            return putForNullKey(value);
//	        int hash = hash(key);
//	        int i = indexFor(hash, table.length);
//	        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
//	            Object k;
//	            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
//	                V oldValue = e.value;
//	                e.value = value;
//	                e.recordAccess(this);
//	                return oldValue;
//	            }
//	        }
//
//	        modCount++;
//	        addEntry(hash, key, value, i);
//	        return null;
//	    }
	
	
	/**
	 * Get方法
	 * 可以看到是拿到对象Entry
	 * 通过对key hash,然后找到数组索引，通过对比hash和key eqs方法，找到则返回此entry, 
	 * 然后对象entry对象里面有get value
	 */
//	  public V get(Object key) {
//	        if (key == null)
//	            return getForNullKey();
//	        Entry<K,V> entry = getEntry(key);
//
//	        return null == entry ? null : entry.getValue();
//	    }
	
//	final Entry<K,V> getEntry(Object key) {
//        if (size == 0) {
//            return null;
//        }
//
//        int hash = (key == null) ? 0 : hash(key);
//        for (Entry<K,V> e = table[indexFor(hash, table.length)];
//             e != null;
//             e = e.next) {
//            Object k;
//            if (e.hash == hash &&
//                ((k = e.key) == key || (key != null && key.equals(k))))
//                return e;
//        }
//        return null;
//    }
}
