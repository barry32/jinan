package com.shanghai.jinan.jvm;

import org.openjdk.jol.info.ClassLayout;

import java.util.Objects;

public class ObjLock02 {

    public static void main(String[] args) {
        /**
         * MarkWork  8 bytes  (64位)
         * Class Pointer 4bytes （开启指针压缩）
         *
         *  实例数据： 占 9 bytes
         *
         *  对齐填充： 3 bytes
         */
        Hero a = new Hero();
        System.out.println("new A:" + ClassLayout.parseInstance(a).toPrintable());

        a.setFlag(true);
        a.setI(1);
        a.setStr("ABC");
        System.out.println("赋值 A:"+ ClassLayout.parseInstance(a).toPrintable());
    }



    static class Hero {
        //1 byte
        private boolean flag;
        //4 byte
        private int i;
        //4 byte
        private String str;


        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }
}




