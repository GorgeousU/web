package com.thread;

public class TestPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程优先级："+Thread.currentThread().getPriority());
    }
    public static void main(String[] args){
        TestPriority t = new TestPriority();
        Thread t1 = new Thread(t,"a");
        Thread t2 = new Thread(t,"b");
        Thread t3 = new Thread(t,"c");
        Thread t4 = new Thread(t,"d");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(8);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
