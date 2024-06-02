package com.shanghai.jinan.day02;

public class HumongousObject {

    public static void main(String[] args) {

        //-Xms60m -Xmx60 -XX:NewRatio=2 , -XX:SurvivorRatio=8,-XX:+PrintGCDetails
        //老年代40m, Eden 20*0.8 = 16m, S0= 2m, S1 = 2m, 新生代： 16+2 = 18m
        byte[] bytes = new byte[1024*1024*20];
        System.out.println(bytes.toString());
    }
}
