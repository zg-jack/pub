package com.zhuguang.jack.java8;

/** 
 * @Description 接口里面定义唯一的抽象方法，那么这个接口就是 函数式接口 
 * @ClassName   FunctionalIntf 
 * @Date        2017年12月21日 下午3:38:39 
 * @Author      zg_jack
 */
@FunctionalInterface
public interface FunctionalIntf {
    String eat(String param);
    
    /** 
     * @Description 这个是函数式接口中的静态方法 
     * @param  参数 
     * @return void 返回类型  
     * @throws 
     */
    static void doSomething() {
        System.out.println("我是一个函数式接口中的静态方法！！！");
    }
    
    /** 
     * @Description 允许在函数式接口里面定义Object顶层父类中的public方法 
     * @param @param paramObject
     * @param @return 参数 
     * @return boolean 返回类型  
     * @throws 
     */
    public boolean equals(Object paramObject);
    
    public String toString();
}
