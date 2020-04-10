package com.nf.com;

public class ThreadSleep implements Runnable {
    int count=0;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"say: hello sleep!!");
        try {
            count();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadSleep ts=new ThreadSleep();
        Thread t1=new Thread(ts,"路人甲");
        Thread t2=new Thread(ts,"路人乙");
        t1.start();
        t2.start();

    }

    public void count() throws InterruptedException {
        while(count<20) {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "say: count is  " + this.count);
                count++;
                Thread.sleep(100);
            }
        }
    }
}
