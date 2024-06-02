package com.shanghai.jinan.jvm;

/**
 * 大对象进入老年代： -Xmx60m -Xms60m -XX:NewRatio=2  -XX:SurvivorRatio=8   -XX:+PrintGCDetails
 * -XX:PretenureSizeThreshold
 */
public class YoungOldArea {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024*1024*20];
    }
}
