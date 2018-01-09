package com.zhuguang.jack.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** 
 * @Description 实现了 InvocationHandler接口的类就是一个通知类，这个类就是对目标对象进行代理
 * @ClassName   ZSParent 
 * @Date        2017年12月15日 下午3:48:20 
 * @Author      zg_jack
 */

public class ZSParent implements InvocationHandler {
    
    People people;
    
    public ZSParent(People people) {
        this.people = people;
    }
    
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        //不是张三的方式，是张三父母帮他做的事情，是一个代理方法...是对张三方法的一个代理
        before();
        people.zhaoduixiang();
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
