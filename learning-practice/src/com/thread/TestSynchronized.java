package com.thread;

public class TestSynchronized {
    public static void main(String[] args){
        Site s = new Site();
        Thread t1 = new Thread(s,"a");
        Thread t2 = new Thread(s,"b");
        Thread t3 = new Thread(s,"c");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Site implements Runnable{
    int count = 10;
    int sum = 0;
    @Override
    public void run() {
        while(true){
            synchronized (this){ //同步代码块，this指调用这个方法的对象(t1或t2或者t3)
                if(count == 0){
                    break;
                }
                count--;
                sum++;
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"购买了第"+sum+"张票，剩余"+count+"张票");
            }
        }
    }
}