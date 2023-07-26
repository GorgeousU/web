package com.thread;

public class MyRunnable implements Runnable{  //实现Runnable接口
    @Override
    public void run() {   //重写run()方法
        for (int i = 0; i < 5; i++) {
            System.out.println("自定义"+Thread.currentThread().getName()+":"+i);
        }
    }
    public static void main(String[] args){
        MyRunnable myRunnable = new MyRunnable();  //创建实现类对象
        Thread t1 = new Thread(myRunnable,"线程1"); //创建代理类对象
        Thread t2 = new Thread(myRunnable,"线程2");
        t1.start();  //start()方法启动线程
        t2.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程"+i);
        }
    }
}
