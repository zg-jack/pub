package com.zhuguang.jack.proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {
    
    private File dir;
    
    public MyClassLoader(String path) {
        dir = new File(path);
    }
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        
        if (dir != null) {
            File clazzFile = new File(dir, name + ".class");
            
            if (clazzFile.exists()) {
                try {
                    FileInputStream input = new FileInputStream(clazzFile);
                    
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    
                    byte[] buffer = new byte[1024];
                    
                    int len;
                    
                    while ((len = input.read(buffer)) != -1) {
                        baos.write(buffer, 0, len);
                    }
                    
                    //最终把我们的输出流输出到jvm内存里面
                    return defineClass("com.zhuguang.jack.proxy." + name,
                            baos.toByteArray(),
                            0,
                            baos.size());
                }
                catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
        }
        return super.findClass(name);
    }
    
}
