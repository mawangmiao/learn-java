package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static final List<String> stringList = new ArrayList<>();

    @Scheduled(fixedRate = 2000)
    public void reportCurrentTime() throws InterruptedException {
        long i = 0;
        while (i < 1000000000000000L) {
            System.out.println(i);
            i++;
        }
        Class clazz = this.getClass();
        Class clazz1 = ScheduledTasks.class;
    }
}