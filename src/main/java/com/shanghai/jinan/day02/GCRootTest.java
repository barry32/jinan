package com.shanghai.jinan.day02;

public class GCRootTest {
    //常量池
    private static final String x = "1";
    //静态变量
    private static  String x1 = "1";
    public static void main(String[] args) {
        //虚拟机栈 ---- 栈帧中的局部变量表
        Object o = new Object();
    }
}
