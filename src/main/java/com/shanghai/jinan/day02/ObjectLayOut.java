package com.shanghai.jinan.day02;

import org.openjdk.jol.info.ClassLayout;

public class ObjectLayOut {
    public static void main(String[] args) {
        //normalObject();
        Student student = new Student();
        System.out.println(ClassLayout.parseInstance(student).toPrintable());
    }


    /**
     * 不带数组： 1+4+4 = 9，MarkWord 8 classPointer 4, 3 对齐填充  === 24
     *不带数组： 1+4+4 = 9，MarkWord 8 classPointer 8,  boolean 1, int 4, String 4 -XX:-UseCompressedClassPointers
     *
     * 带数组： -XX:-UseCompressedClassPointers
     * MarkWord  8字节 (64位)， ClassPointer 8字节， flag 1， int 4， 数组占[]  4个字节【不区分 int[] char[]】。
     */
    static class Student {
        //1 字节
        private boolean flag;
        //4字节
        //private char[] ext;
        //4字节
        private int number;
        //4字节
        private String name;
    }

    private static void normalObject() {
        Object object = new Object();
        /**
         * MarkWord = 4字节 ， 64位  8字节
         * ClassPointer 4字节  ---
         * 对齐填充 4字节 = 16字节
         *
         *
         * 关闭指针压缩： MarkWord  8字节， ClassPointer 8字节
         * 没有对齐填充   -XX:-UseCompressedClassPointers
         *
         */
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }
}
