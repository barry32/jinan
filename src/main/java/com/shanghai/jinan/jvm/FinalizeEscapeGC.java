package com.shanghai.jinan.jvm;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;


    public void isAlive() {
        System.out.println("你瞅啥, 哥还活着 :)");
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("执行finalize()");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }


    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("哦不, 哥死了 :(");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("哦不, 哥死了 :(");
        }
    }

}
