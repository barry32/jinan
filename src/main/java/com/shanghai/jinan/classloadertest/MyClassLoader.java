package com.shanghai.jinan.classloadertest;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;

public class MyClassLoader extends ClassLoader {


    private String classpath;

    public MyClassLoader(String classpath) {
        this.classpath = classpath;
    }



    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classData = getData(name);
            //读取到二进制流数据后，生成Class对象
            if (classData != null) {
                return defineClass(name, classData, 0, classData.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }


    private byte[] getData(String className) {
        //根据全限定名称找到类
        String path = classpath + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        System.out.println(className+ "的实际存放地址："+ path);
        System.out.println( "答应当前的堆栈信息："+ Arrays.toString(Thread.currentThread().getStackTrace()));
        try (InputStream in = new FileInputStream(path);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.flush();
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
