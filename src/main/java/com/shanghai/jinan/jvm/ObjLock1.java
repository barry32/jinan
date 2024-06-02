package com.shanghai.jinan.jvm;

import org.openjdk.jol.info.ClassLayout;

public class ObjLock1 {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println("new Object:"+ ClassLayout.parseInstance(o).toPrintable());
    }
}
