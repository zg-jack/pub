package com.zhuguang.jack.finnally;

/** 
 *  往期视频加小露老师QQ：1533922121
 *  Jack老师QQ： 2943489129
 *  时间   ：     2018年1月9日 下午2:35:21 
 *  作者   ：   烛光学院【Jack老师】
 *  
 *  总结：finally语句块中的return会覆盖try语句块中的return
 */

public class FinallyDemo4 {
    
    public static void main(String[] args) {
        System.out.println(test());
    }
    
    public static int test() {
        int i = 20;
        try {
            System.out.println("try语句块执行");
            return i += 20;
        }
        catch (Exception e) {
            System.out.println("catch语句块执行");
        }
        finally {
            System.out.println("finally语句块执行");
            if (i > 25) {
                System.out.println("i>25,i=" + i);
            }
            return 1000;
        }
        
    }
}
