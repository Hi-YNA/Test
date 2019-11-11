package com.example.consumerservice.test;

public class SyncTest {

    //一个线程获取了该对象的锁之后，其他线程来访问其他synchronized实例方法现象
    //结果：可以看出其他线程来访问synchronized修饰的其他方法时需要等待线程1先把锁释放

    public synchronized void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    //一个线程获取了该对象的锁之后，其他线程来访问其他非synchronized实例方法现象 举栗去掉方法二的synchronized
    //结果：当线程1还在执行时，线程2也执行了，所以当其他线程来访问非synchronized修饰的方法时是可以访问的

    public synchronized void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }


    public static void main(String[] args) {
        final SyncTest test = new SyncTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method2();
            }
        }).start();
    }

}
