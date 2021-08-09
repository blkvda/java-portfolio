package com.home;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class CustomCallable implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        System.out.println(String.format("from %s \tthread name: %s, time: %s", this.getClass().getSimpleName(), Thread.currentThread().getName(), LocalTime.now()));
        Thread.sleep(500);
        return Thread.currentThread().getId();
    }
}
