package com.paymoon.hashmap$eqs.copy;
public class SourceCode$bitwise{
	//涉及的知识点，位与运算，
	//Java 位运算(移位、位与、或、异或、非） - Ely's Blog - 博客频道 - CSDN.NET
    //	http://blog.csdn.net/xiaochunyong/article/details/7748713
	
//	位运算、异或的实际应用 - 无忌 - ITeye技术网站
//	http://nassir.iteye.com/blog/1994914
	public static void main(String[] args) {
		System.err.println(9<<4);
		System.err.println(85&8989);//
		
	}
	/**
     * java7中hashmap中寻找数组index使用这种方式
     * Returns index for hash code h.
     * h:key的hash（非常重要）
     * length: table的长度
     */
	 static int indexFor(int h, int length) {
	        // assert Integer.bitCount(length) == 1 : "length must be a non-zero power of 2";
	        return h & (length-1);
	    }
}
