package com.tgb.proxy;
import java.lang.reflect.Method;
public class $Proxy1 implements com.tgb.proxy.UserMgr{
    public $Proxy1(InvocationHandler h) {
        this.h = h;
    }
    com.tgb.proxy.InvocationHandler h;
    @Override
    public  void addUser() {
        try {
        Method md = com.tgb.proxy.UserMgr.class.getMethod("addUser");
        h.invoke(this, md);
        }catch(Exception e) {e.printStackTrace();}
    }
    @Override
    public  void delUser() {
        try {
        Method md = com.tgb.proxy.UserMgr.class.getMethod("delUser");
        h.invoke(this, md);
        }catch(Exception e) {e.printStackTrace();}
    }

}