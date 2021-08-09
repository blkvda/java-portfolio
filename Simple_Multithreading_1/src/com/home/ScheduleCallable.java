package com.home;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class ScheduleCallable implements Callable<LocalTime> {
    @Override
    public LocalTime call() {
        LocalTime localTime = LocalTime.now();
        System.out.println(String.format("from %s \tthread name: %s, time: %s", this.getClass().getSimpleName(), Thread.currentThread().getName(), localTime));
        return localTime;
    }
}
