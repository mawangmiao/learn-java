package com.example.demo;

class ThreadDemo implements Runnable {
    private int tickets = 100;

    public void run() {
        while (true) {
            sale();
        }
    }

    private void sale() {
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + " is saling ticket " + tickets--);
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        ThreadDemo t = new ThreadDemo();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}