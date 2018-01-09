package com.zhuguang.jack.finnally;

public class MyTest {
    
    public static void main(String[] args) {
        System.out.println(test());
    }
    
    private static int test() {
        try {
            System.out.println("执行try语句块！");
            return 1;
        }
        finally {
            System.out.println("执行finally语句块！");
            return 2;
        }
    }
    
}
