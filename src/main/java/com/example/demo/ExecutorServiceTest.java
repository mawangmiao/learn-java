package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ExecutorServiceTest {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log.info("获得锁");
        lock.lock();

        ExecutorService executorService = Executors.newCachedThreadPool(runnable -> {
            Thread thread = new Thread(runnable);
            thread.setUncaughtExceptionHandler(((t, e) -> log.error("UncaughtExceptionHandler", e)));
            return thread;
        });

/*        executorService.submit(() -> {
            try {
                log.info("开始");
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                log.error("lockInterruptibly", e);
            } finally {
                log.info("退出");
            }
        });

        executorService.submit(() -> {
            log.info("开始");
            try {
                lock.tryLock(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                log.error("tryLock", e);
            }
            log.info("退出");
        });*/

        executorService.execute(() -> {
            log.info("抛出execute异常");
            throw new RuntimeException("execute异常");
        });

        Future future = executorService.submit(() -> {
            log.info("抛出submit异常");
            throw new RuntimeException("submit异常");
        });
        try {
            future.get();
        } catch (Exception e) {
            log.error("future.get", e);
        }


        Thread.sleep(3000);
//        executorService.shutdownNow();
//        log.info("释放锁");
//        lock.unlock();
        Thread.sleep(5000);
        log.info("退出");
    }
}
