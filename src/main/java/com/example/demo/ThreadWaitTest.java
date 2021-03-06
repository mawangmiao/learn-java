package com.example.demo;

import java.util.Vector;


public class ThreadWaitTest {
    public static void main(String args[]) {
        Vector obj = new Vector();
        Thread consumer = new Thread(new Consumer(obj));
        Thread producer = new Thread(new Producer(obj));
        consumer.start();
        producer.start();
    }
}

/*消费者 */
class Consumer implements Runnable {
    private Vector obj;

    public Consumer(Vector v) {
        this.obj = v;
    }

    public void run() {
        synchronized (obj) {
            while (true) {
                try {
                    if (obj.size() == 0) {
                        obj.wait();
                    }
                    System.out.println("Consumer:goods " + obj.toString() + " have been taken");
                    System.out.println("obj size: " + obj.size());
                    Thread.sleep(15 * 1000);
                    obj.clear();
                    obj.notify();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/*  生产者 */
class Producer implements Runnable {
    private Vector obj;

    public Producer(Vector v) {
        this.obj = v;
    }

    public void run() {
        synchronized (obj) {
            while (true) {
                try {
                    if (obj.size() != 0) {
                        obj.wait();
                    }

                    obj.add(new String("apples"));
                    obj.notify();
                    System.out.println("Producer:obj are ready");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

