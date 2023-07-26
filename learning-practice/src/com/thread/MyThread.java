package com.thread;

public class MyThread extends Thread{ //创建一个类MyThread继承Thread
    public MyThread(){}      //重写Thread的构造方法
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run(){    //重写run()方法
        for (int i = 0; i < 5; i++) {
                System.out.println("自定义"+Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args){  //main线程，主线程
        MyThread t1 = new MyThread("线程1");//创建线程实现类对象
        MyThread t2 = new MyThread("线程2");
        t1.start();//调用start()方法启动线程
        t2.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程"+i);
        }
    }
}
