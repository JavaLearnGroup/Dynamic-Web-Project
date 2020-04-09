package com.nf.com;

public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("这个一个线程"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread mt=new MyThread();
        Thread t=new Thread(mt);
        Thread t1=new Thread(mt);
        t.start();
        t1.start();

    }
}
