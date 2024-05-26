package com.shanghai.jinan.jvm;

import java.nio.ByteBuffer;

public class ByteBufferCompareNIO {
    public static void main(String[] args) {
        //allocateCompare();
        operateCompare();
    }

    /**
     * 直接内存和 堆内存空间分配
     * 结论： 在数据量提升时，直接内存相比非直接内存的申请，有很严重的性能问题
     */
    public static void allocateCompare() {
        int time = 1000 * 1000;
        long st = System.currentTimeMillis();
        for (int i =0; i<time; i++) {
            // 堆内存分配
            ByteBuffer buffer = ByteBuffer.allocate(2);
        }
        long et = System.currentTimeMillis();
        System.out.println("在进行" + time + "次分配操作时，堆内存 分配耗时:" +
                (et - st) + "ms");

        long st_heap = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(2); //直接内存分配申请
        }
        long et_direct = System.currentTimeMillis();
        System.out.println("在进行" + time + "次分配操作时，直接内存 分配耗时:" +
                (et_direct - st_heap) + "ms");
    }


    public static void operateCompare() {
        int time = 10 * 10000 * 10000;
        ByteBuffer buffer = ByteBuffer.allocate(2 * time);
        long st = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            // putChar(char value) 用来写入 char 值的相对 put 方法
            buffer.putChar('a');
        }
        buffer.flip();
        for (int i = 0; i < time; i++) {
            buffer.getChar();
        }
        long et = System.currentTimeMillis();
        System.out.println("在进行" + time + "次读写操作时，非直接内存读写耗时：" +
                (et - st) + "ms");

        ByteBuffer buffer_d = ByteBuffer.allocateDirect(2* time);
        long st_direct = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            // putChar(char value) 用来写入 char 值的相对 put 方法
            buffer_d.putChar('a');
        }
        buffer_d.flip();
        for (int i = 0; i< time; i++) {
            buffer_d.getChar();
        }
        long et_direct = System.currentTimeMillis();
        System.out.println("在进行" + time + "次读写操作时，直接内存读写耗时:" +
                (et_direct - st_direct) + "ms");
    }







}
