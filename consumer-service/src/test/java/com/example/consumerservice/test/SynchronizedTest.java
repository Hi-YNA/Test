package com.example.consumerservice.test;

public class SynchronizedTest implements Runnable{
    //多个线程访问同一个对象的同一个方法
    //结果：当两个线程同时对一个对象的一个方法进行操作，只有一个线程能够抢到锁。
    //因为一个对象只有一把锁，一个线程获取了该对象的锁之后，其他线程无法获取该对象的锁，就不能访问该对象的其他synchronized实例方法，但是可以访问非synchronized修饰的方法

    //共享资源
    static int i =0;
    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase(){
        i++;
    }

    @Override
    public void run(){
        for (int j =0 ; j<10000;j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        SynchronizedTest test = new SynchronizedTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
        t1.join();
        System.out.println(i);
        t2.join();
        System.out.println(i);
    }


}
