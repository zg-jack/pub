package com.zhuguang.jack.proxy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

public class MyTest {
    
    public static void main(String[] args) throws Throwable {
        System.out.println("-------------------------JDK的动态代理------------------------------");
        //这个方法返回一个代理类
        People people = (People)Proxy.newProxyInstance(People.class.getClassLoader(),
                new Class[] {People.class},
                new ZSParent(new Zhangsan()));
        
        people.zhaoduixiang();
        
        //        createProxyClassFile();
        
        System.out.println("-------------------------烛光Jack老师的动态代理------------------------------");
        People jackpeople = (People)MyProxy.newProxyInstance(People.class.getClassLoader(),
                People.class,
                new JackZSParent(new Zhangsan()));
        jackpeople.zhaoduixiang();
        
    }
    
    public static void createProxyClassFile() {
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0.class",
                new Class[] {People.class});
        
        try {
            FileOutputStream out = new FileOutputStream("$Proxy0.class");
            out.write(data);
            out.close();
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
