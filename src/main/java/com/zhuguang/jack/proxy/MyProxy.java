package com.zhuguang.jack.proxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/** 
 * @Description jack老师自定义的动态代理类 
 * @ClassName   MyProxy 
 * @Date        2017年12月15日 下午4:16:02 
 * @Author      zg_jack
 */

public class MyProxy {
    
    static String rt = "\r\n";
    
    /** 
     * @Description 这个方法就是创建出内存中的代理实例 
     * @param @param loader
     * @param @param intf
     * @param @param handler
     * @param @return 参数 
     * @return Object 返回类型  
     * @throws 
     */
    
    public static Object newProxyInstance(ClassLoader loader, Class intf,
            MyInvocationHandler handler) {
        try {
            Method[] methods = intf.getMethods();
            
            //1、字符串拼凑的方式把内存里面的代理类拼凑出来
            String proxyClass = "package com.zhuguang.jack.proxy;" + rt
                    + "import java.lang.reflect.Method;" + rt
                    + "public class $Proxy0 implements " + intf.getName() + "{"
                    + rt + "MyInvocationHandler h;" + rt
                    + "public $Proxy0(MyInvocationHandler h) {" + rt
                    + "this.h = h;" + rt + "}" + getMethodString(methods, intf)
                    + rt + "}";
            
            //2、用IO流的方式把java的string写入到文件中
            String fileName = "D:/workspace/zg_school/pub/src/main/java/com/zhuguang/jack/proxy/$Proxy0.java";
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            fw.write(proxyClass);
            fw.flush();
            fw.close();
            
            //3、对我们前面生成的java文件进行编译
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null,
                    null,
                    null);
            Iterable units = fileMgr.getJavaFileObjects(fileName);
            CompilationTask t = compiler.getTask(null,
                    fileMgr,
                    null,
                    null,
                    null,
                    units);
            t.call();
            fileMgr.close();
            
            //4、把磁盘里面的.class文件把它加载到内存中来
            MyClassLoader loader1 = new MyClassLoader(
                    "D:/workspace/zg_school/pub/src/main/java/com/zhuguang/jack/proxy");
            //就是内存里面的代理类的反射对象
            Class<?> proxy0Clazz = loader1.findClass("$Proxy0");
            
            Constructor m = proxy0Clazz.getConstructor(MyInvocationHandler.class);
            
            Object o = m.newInstance(handler);
            
            return o;
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    private static String getMethodString(Method[] methods, Class intf) {
        
        String proxyMe = "";
        
        for (Method method : methods) {
            proxyMe += "public void " + method.getName()
                    + "() throws Throwable {" + rt + "Method md = "
                    + intf.getName() + ".class.getMethod(\"" + method.getName()
                    + "\",new Class[]{});" + rt
                    + "this.h.invoke(this,md,null);" + rt + "}" + rt;
        }
        
        return proxyMe;
    }
}
