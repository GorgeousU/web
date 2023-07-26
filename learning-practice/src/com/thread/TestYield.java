package com.thread;

public class TestYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始执行");
        Thread.yield();//将当前执行的线程变成”就绪状态“，并执行其他线程
        System.out.println(Thread.currentThread().getName()+"结束执行");
    }
    public static void main(String[] args){
        TestYield t = new TestYield();
        Thread t1 = new Thread(t,"线程a");
        Thread t2 = new Thread(t,"线程b");
        t1.start();
        t2.start();
    }
}
