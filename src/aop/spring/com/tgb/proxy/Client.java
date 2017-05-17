package com.tgb.proxy;

import java.lang.reflect.Method;

public class Client {  
    public static void main(String[] args) throws Exception {  
        UserMgr mgr = new UserMgrImpl();  

        //1 为用户管理添加事务处理  
        InvocationHandler h = new TransactionHandler(mgr);  
        UserMgr u = (UserMgr)Proxy.newProxyInstance(UserMgr.class,h);  

        //2 为用户管理添加显示方法执行时间的功能  
        TimeHandler h2 = new TimeHandler(u);  
        u = (UserMgr)Proxy.newProxyInstance(UserMgr.class,h2);  
        
        //此时的用户u已经不是UserMgr，而是$Proxy1.java,Proxy1.java implements com.tgb.proxy.UserMgr
        u.addUser();  
        //执行流程。。。
        //3 u.addUser代理开始调用
        //4 Method md = com.tgb.proxy.UserMgr.class.getMethod("addUser");
        //5 h.invoke(this, md);
        //6 h是TimeHandler，然后打印开始时间，然后调用TimeHandler的m.invoke(target);，等这个方法完打印结束时间，this没有用到
        //7 TimeHandler的m.invoke(target)调用中，执行target的addUser方法，但是target是1中的UserMgr u，u仍然是代理，仍然是proxy1
        //8 循环3~6
        //9 执行到了TransactionHandler的m.invoke(target)，打印开启事务，执行target的addUser方法，此时target是 UserMgr mgr = new UserMgrImpl(); ，mgr不再是代理，是真正的业务
        //10 执行真正业务的adduser
        //11 返回到9中执行完毕，打印提交事务
        //12 返回到6中时间方法执行完毕，打印结束时间
        
        System.out.println("\r\n==========华丽的分割线==========\r\n");  
        u.delUser();  
    }  
} 