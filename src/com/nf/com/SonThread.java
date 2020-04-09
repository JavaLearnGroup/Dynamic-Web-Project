package com.nf.com;

public class SonThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread子类实现多线程:  "+Thread.currentThread().getName());
        int sum=0;
        for(int i=0;i<50;i++){
            sum=sum+i;
            System.out.println(sum+" "+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        SonThread st=new SonThread();
        st.setName("线程一");
        SonThread st2=new SonThread();
        st2.setName("线程二");
        SonThread st3=new SonThread();
        st3.setName("线程三");
        SonThread st4=new SonThread();
        st4.setName("线程四");
        st.start();
        st2.start();
        st3.start();

        st4.start();
        st3.start();
        st4.start();
    }
}
