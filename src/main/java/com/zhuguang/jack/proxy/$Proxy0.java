package com.zhuguang.jack.proxy;
import java.lang.reflect.Method;
public class $Proxy0 implements com.zhuguang.jack.proxy.People{
MyInvocationHandler h;
public $Proxy0(MyInvocationHandler h) {
this.h = h;
}public void zhaoduixiang() throws Throwable {
Method md = com.zhuguang.jack.proxy.People.class.getMethod("zhaoduixiang",new Class[]{});
this.h.invoke(this,md,null);
}

}