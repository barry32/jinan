package com.shanghai.jinan.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HeapInstance {
    /**
     * 对象分配  每间隔20毫秒，生成一个1M对象 模拟GC情况。
     *
     *  -Xms600m   -Xmx600m  -XX:+PrintGCDetails
     * @param args
     */

    public static void main(String[] args) {
        List<Picture> list = new ArrayList<>();
        while (true) {
            try {
                Thread.sleep(20);
            } catch (Exception e) {
                e.printStackTrace();
            }
            list.add(new Picture(new Random().nextInt(1024*1024)));
        }

    }

    static class Picture {
        private byte[] pixels;
        public Picture(int length) {
            this.pixels = new byte[length];
        }



    }


}
