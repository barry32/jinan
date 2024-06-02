package com.shanghai.jinan.day02;

public class MyFinalize {


    private static MyFinalize newObj = null;
    public static void main(String[] args) throws InterruptedException {
        newObj = new MyFinalize();
        newObj = null;
        System.gc();
        Thread.sleep(500);
        if (newObj != null) {
            newObj.isAlive();
        } else {
            System.out.println("死了。。。。");
        }


        newObj = null;
        System.gc();
        Thread.sleep(500);
        if (newObj != null) {
            newObj.isAlive();
        } else {
            System.out.println("死了。。。。");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("开始执行Finalize...");
        super.finalize();
        newObj = this;
    }


    public void isAlive() {
        System.out.println("你瞅啥, 哥还活着 :)");
    }
}
