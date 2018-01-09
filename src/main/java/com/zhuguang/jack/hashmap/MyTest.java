package com.zhuguang.jack.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MyTest {
    
    public static void main(String[] args) {
        Map<String, String> jdkmap = new HashMap<String, String>();
        
        Long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            jdkmap.put("ZGjack" + i, "zhuguangschool" + i);
        }
        
        for (int i = 0; i < 1000; i++) {
            System.out.println(jdkmap.get("ZGjack" + i));
        }
        Long t2 = System.currentTimeMillis();
        System.out.println("jdk time : " + (t2 - t1));
        
        System.out.println("---------------------------------------------------------");
        
        ZGMap<String, String> zgmap = new ZGHashMap<String, String>();
        
        Long t3 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            zgmap.put("ZGjack" + i, "zhuguangschool" + i);
        }
        
        for (int i = 0; i < 1000; i++) {
            System.out.println(zgmap.get("ZGjack" + i));
        }
        Long t4 = System.currentTimeMillis();
        System.out.println("zghashMap time : " + (t4 - t3));
    }
    
}
