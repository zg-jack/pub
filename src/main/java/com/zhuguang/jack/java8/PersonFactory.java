package com.zhuguang.jack.java8;

import java.util.function.Supplier;

public class PersonFactory {
    
    /** 
     * @Fields supplier 可以把这个东西看成是一个容器，容器里面装的是Person对象 
     * 
     * 这个东西是不是跟我们的ThreadLocal很想？
     */
    
    Supplier<Person> supplier;
    
    public PersonFactory(Supplier<Person> supplier) {
        this.supplier = supplier;
    }
    
    public Person getPerson() {
        return supplier.get();
    }
}
