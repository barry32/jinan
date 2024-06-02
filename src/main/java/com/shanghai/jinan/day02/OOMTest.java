package com.shanghai.jinan.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OOMTest {
    public static void main(String[] args) throws InterruptedException {

        /**
         * -Xms60m, -Xmx60m, -XX:NewRatio=2, -XX:SurvivorRatio=8,
         * 老年代 40m, Eden=16m, S0=2m s1=2m, 新生代：18m
         *
         * ---> 导致每次MinorGC 对象超过Survivor的都存入到 老年代。但是又是强引用。
         *
         * 每隔 10ms 生成2m对象。
         */
        List<Byte> byteList = new ArrayList<>();
        Thread.sleep(10000);
        System.out.println("开始了");
        while(true) {
            Byte[] bytes = new Byte[1024 * 1024 * 2];
            byteList.addAll(Arrays.asList(bytes));
            Thread.sleep(2000);
        }
    }
}
