package com.thread;

public class TestDaemon {
    public static void main(String[] args){
        DaemonThread daemonThread = new DaemonThread();
        UserThread userThread = new UserThread();
        Thread daemon = new Thread(daemonThread);

        daemon.setDaemon(true);//true,将daemon设置为守护进程
        daemon.start();

        Thread user = new Thread(userThread);
        user.start();
    }
}
class DaemonThread implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("守护线程");
        }
    }
}
class UserThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("用户线程："+i);
        }
    }
}