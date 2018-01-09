package com.zhuguang.jack.java8;

@FunctionalInterface
public interface FuncitonalIntf2 {
    String convert(Integer num);
    
    static String sleep(String param) {
        return null;
    }
    
    default String doSomething(String param) {
        return "烛光学院【Jack老师】doSomething";
    }
    
    default String doSomething1(String param) {
        return null;
    }
    
    default String doSomething2(String param) {
        return null;
    }
    
}
