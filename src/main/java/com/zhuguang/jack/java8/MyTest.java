package com.zhuguang.jack.java8;

public class MyTest {
    
    public static void main(String[] args) {
        
        FunctionalIntf intf = new FunctionalIntf() {
            @Override
            public String eat(String param) {
                return "烛光学院【Jack老师】";
            }
        };
        System.out.println(intf.eat(""));
        
        //这个就是一个标准的lambda表达式
        FunctionalIntf intf2 = (param) -> {
            return "烛光学院【Jack老师】--lambda";
        };
        System.out.println(intf2.eat(""));
        
        //如果lambda表达式中的方法体中只有一行代码，那么lambda表达式还可以简写
        FunctionalIntf intf3 = (param) -> "烛光学院【Jack老师】--lambda--如果只有一行代码的简写方式";
        System.out.println(intf3.eat(""));
        
    }
}
