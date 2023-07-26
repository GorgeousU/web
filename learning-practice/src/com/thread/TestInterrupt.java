package com.thread;

public class TestInterrupt implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---->begin");
        try {
            Thread.sleep(1000*60*60*24*365);//设置睡眠时间为一年
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"---->end");
    }
    public static void main(String[] args){
        Thread t = new Thread(new TestInterrupt());
        t.setName("t");
        t.start();
        try{
            Thread.sleep(1000*3);//设置t线程三秒后醒来
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        t.interrupt();//终断t线程的睡眠（依靠了异常处理机制）
    }
}
