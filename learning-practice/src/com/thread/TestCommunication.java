package com.thread;

public class TestCommunication {
    public static void main(String[] args){
        Box box = new Box();
        Producer producer = new Producer(box);
        Customer customer = new Customer(box);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(customer);
        t1.start();
        t2.start();
    }
}

class Box{  //箱子
    private int milk;//放入的第几瓶牛奶
    private boolean flag = false; //默认箱子内的牛奶数量为0
    public synchronized void put(int milk){ //放入牛奶
        if(flag){ //若箱子中有牛奶,生产者等待
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }else{ //若箱中没有牛奶，则生产牛奶
            this.milk = milk;
            System.out.println("a将第"+this.milk+"瓶牛奶放入了箱子");
            this.flag = true;//箱子中有牛奶
            notifyAll();//唤醒所有等待的线程
        }
    }
    public synchronized void get(){
        if(!flag){ //如果箱子中没有牛奶，则等待
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("b将第"+this.milk+"瓶牛奶取走了");
            this.flag = false;//将箱子设置为空的状态
            notifyAll();//唤醒所有等待的线程
        }
    }
}
class Producer implements Runnable{
    private Box b;
    public Producer(Box b){
        this.b = b;
    }
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            b.put(i);
        }
    }
}
class Customer implements Runnable{
    private Box b;
    public Customer(Box b){
        this.b = b;
    }
    @Override
    public void run() {
        while(true){
            b.get();
        }
    }
}