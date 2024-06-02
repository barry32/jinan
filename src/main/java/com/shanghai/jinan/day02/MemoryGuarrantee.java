package com.shanghai.jinan.day02;

class MemoryGuarantee {

    /**
     * 内存担保机制： 是Eden区域已经存在对象，新来的对象导致放不下。触发MinorGC ，Survivor区域又放不下，
     *
     * -XX:SurvivorRatio=8, -Xms30m, -Xmx30m,-XX:NewRatio=2， -XX:+PrintGCDetails
     * 老年代 20m, Eden区域 10m， s0=1m, s1 = 1m  Eden=8m
     * @param args
     */
    public static void main(String[] args) {
        byte[] byte1 = new byte[1024 * 1024 * 1];
        byte[] byte2 = new byte[1024 * 1024 * 1];
        byte[] byte3 = new byte[1024 * 1024 * 1];
        byte[] byte4 = new byte[1024 * 1024 * 5];

    }
}
