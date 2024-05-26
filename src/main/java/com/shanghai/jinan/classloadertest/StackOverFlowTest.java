package com.shanghai.jinan.classloadertest;

public class StackOverFlowTest {
    private static int index =1;
    public void call() {
        index++;
        call();
    }

    public static void main(String[] args) {
        StackOverFlowTest stackOverFlowTest = new StackOverFlowTest();
        try {
            stackOverFlowTest.call();
        }catch (Throwable e) {
            System.out.println("stack deep: "+ index);
            e.printStackTrace();
        }
    }
}
