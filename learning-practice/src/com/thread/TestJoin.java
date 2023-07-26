package com.thread;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+"线程join执行："+i);
        }
    }
    public static void main(String[] args){
        TestJoin t = new TestJoin();
        Thread t1 = new Thread(t,"a");
        t1.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程："+i);
            if(i == 2){
                try{
                    t1.join();//当主线程执行到2时，阻塞主线程，并执行子线程a，等待子线程执行结束后，再继续执行主线程
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
