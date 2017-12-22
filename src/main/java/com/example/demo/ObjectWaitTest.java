package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class ObjectWaitTest {
    private final static Object lock = new Object();
    public static void main(String[] args) {

        new Thread(() -> {
            try {
                synchronized (lock) {
                    log.info("get the lock and then release it");
                    lock.wait();
                    log.info("retained lock and stop waiting");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            log.info("sleep");
            Thread.sleep(2 * 1000);
            log.info("sleep end");
            synchronized (lock) {
                log.info("get the lock");
                lock.notify();
                log.info("lock.notify() but still retain lock");
                Thread.sleep(5 * 1000);
                log.info("sleep end and release lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}