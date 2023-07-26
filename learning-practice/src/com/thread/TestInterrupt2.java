package com.thread;

public class TestInterrupt2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (r1) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }
    boolean r1 = true;
    public static void main(String[] args){
        TestInterrupt2 r = new TestInterrupt2();
        Thread t = new Thread(r);
        t.setName("t");
        t.start();
        try{
            Thread.sleep(1000*3);//设置t线程3秒后终止
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        r.r1 = false;
    }
}
