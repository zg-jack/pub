package com.zhuguang.jack.proxy;

import java.lang.reflect.Method;

public class JackZSParent implements MyInvocationHandler {
    People people;
    
    public JackZSParent(People people) {
        this.people = people;
    }
    
    public Object invoke(Object proxy, Method method, Object args) {
        //不是张三的方式，是张三父母帮他做的事情，是一个代理方法...是对张三方法的一个代理
        before();
        try {
            people.zhaoduixiang();
        }
        catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //这个也是一个代理方法，在张三的方法调用完后，帮他做一些工作...是对张三方法的一个代理
        after();
        return null;
    }
    
    private void before() {
        System.out.println("我是张三的父母，我们在他之前帮他找好对象！！！");
    }
    
    private void after() {
        System.out.println("我是张三的父母，张三生完小孩我们帮他带小孩！！！");
    }
    
}
