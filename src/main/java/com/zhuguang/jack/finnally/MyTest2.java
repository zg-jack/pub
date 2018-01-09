package com.zhuguang.jack.finnally;

public class MyTest2 {
    
    public static void main(String[] args) {
        System.out.println(test());
    }
    
    public static int test() {
        int i = 1;
        try {
            return i;
        }
        finally {
            i++;
        }
    }
    
}
