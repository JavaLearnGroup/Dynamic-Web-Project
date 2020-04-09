package com.nf.com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable {
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for(int i=0;i<50;i++){
            sum+=i;
            System.out.println(sum+"线程"+Thread.currentThread().getName());
        }
        return sum;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc=new MyCallable();
        FutureTask ft=new FutureTask(mc);
        FutureTask ft2=new FutureTask(mc);
        FutureTask ft3=new FutureTask(mc);
        FutureTask ft4=new FutureTask(mc);
        Thread t1=new Thread(ft);
        Thread t2=new Thread(ft2);
        t1.setName("线程一");
        t2.setName("线程二");
        Thread t3=new Thread(ft3);
        t3.setName("线程三");
        Thread t4=new Thread(ft4);
        t4.setName("线程四");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
      System.out.println("FutureTask1: "+ft.get().toString());
        System.out.println("FutureTask2: "+ft2.get().toString());
        System.out.println("FutureTask3: "+ft3.get().toString());
        System.out.println("FutureTask4: "+ft4.get().toString());
    }
}
