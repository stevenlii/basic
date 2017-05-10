package com.paymoon.hashmap$eqs.copy;

import java.util.HashMap;
/**
 * JDK 1.8
 * @author yol
 *
 * @param <K>
 * @param <V>
 */
import java.util.Map;
public class HashMap$PutGet_JDK8<K,V> extends HashMap<K, V>{
	/**
	 * haspmap jdk8.0的put方法,
	 * 比7增加了几个参数（见putVal方法注释）
	 * 主要逻辑和7相同，不过是方法优化了下，然后Entry类名改成了（Node），还是静态内部类，
	 * [ava.util.HashMap.Node]( static class Node<K,V> implements Map.Entry<K,V>)（1.7是static class Entry<K,V> implements Map.Entry<K,V>）
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
	Map<String, Object> map = new HashMap<>();
	
	/**
     * Implements Map.put and related methods
     *
     * @param hash hash for key
     * @param key the key
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value
     * @param evict if false, the table is in creation mode.
     * @return previous value, or null if none
     */
//	 public V put(K key, V value) {
//	        return putVal(hash(key), key, value, false, true);
//	    }
	
//	final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//            boolean evict) {
// Node<K,V>[] tab; Node<K,V> p; int n, i;
// if ((tab = table) == null || (n = tab.length) == 0)
//     n = (tab = resize()).length;
// if ((p = tab[i = (n - 1) & hash]) == null)
//     tab[i] = newNode(hash, key, value, null);
// else {
//     Node<K,V> e; K k;
//     if (p.hash == hash &&
//         ((k = p.key) == key || (key != null && key.equals(k))))
//         e = p;
//     else if (p instanceof TreeNode)
//         e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//     else {
//         for (int binCount = 0; ; ++binCount) {
//             if ((e = p.next) == null) {
//                 p.next = newNode(hash, key, value, null);
//                 if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                     treeifyBin(tab, hash);
//                 break;
//             }
//             if (e.hash == hash &&
//                 ((k = e.key) == key || (key != null && key.equals(k))))
//                 break;
//             p = e;
//         }
//     }
//     if (e != null) { // existing mapping for key
//         V oldValue = e.value;
//         if (!onlyIfAbsent || oldValue == null)
//             e.value = value;
//         afterNodeAccess(e);
//         return oldValue;
//     }
// }
// ++modCount;
// if (++size > threshold)
//     resize();
// afterNodeInsertion(evict);
// return null;
//}
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
