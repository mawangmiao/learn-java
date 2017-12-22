package com.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 有三个线程T1 T2 T3，如何保证他们按顺序执行-转载
在T2的run中，调用t1.join，让t1执行完成后再让T2执行
在T2的run中，调用t2.join，让t2执行完成后再让T3执行
*/
public class ThreadByOrder {

    public static void main(String[] args) throws InterruptedException {
        final Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 1");
            }
        }, "T1");
        final Thread t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 2");
                try {
                    t1.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T2");
        final Thread t3 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 3");
                try {
                    t2.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T3");
        // method1
        //t1.start();
        //t2.start();
        //t3.start();

//        method 2 使用 单个任务的线程池来实现。保证线程的依次执行
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        executor.shutdown();
    }
}
