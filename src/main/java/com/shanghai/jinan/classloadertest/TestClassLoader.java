package com.shanghai.jinan.classloadertest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader("D:\\test_lib");
        //包名 + 类名
        Class<?> aClass = myClassLoader.findClass("com.shanghai.jinan.classloadertest.Student");
        if (aClass != null) {
            Object object = aClass.newInstance();
            Method say = aClass.getMethod("say");
            say.invoke(object, null);
            System.out.println(aClass.getClassLoader().toString());
        }

    }
}
