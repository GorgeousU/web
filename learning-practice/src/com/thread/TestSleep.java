package com.thread;

public class TestSleep implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {    //run()方法中的异常只能由try...catch抛出，因为run()父类没有抛出异常，子类不能比父类抛出更多异常
                Thread.sleep(1000);//让当前线程睡眠1s，即每过1s输出一个数字
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        TestSleep testSleep = new TestSleep();
        Thread t1 = new Thread(testSleep);
        t1.start();
    }
}
