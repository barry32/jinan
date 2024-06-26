package com.shanghai.jinan.classloadertest;

import java.nio.ByteBuffer;

public class StringPoolTest {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("abc");
        System.out.println(str1 == str2);
        String str3 = new String("abc");
        System.out.println(str2 == str3);

        String str4 = "a" + "b";
        System.out.println(str4 == "ab");

        String s1 = "a";
        String s2 = "b";
        String str6 = s1 + s2;
        System.out.println(str6 == "ab");

        String str7 = "abc".substring(0,2);
        System.out.println(str7 == "ab");//false
        String str8 = "abc".toUpperCase();
        System.out.println(str8 == "ABC");//false

        String s5 = "a";
        String s6 = "abc";
        String s7 = s5 + "bc";
        System.out.println(s6 == s7.intern());//true

    }
}
