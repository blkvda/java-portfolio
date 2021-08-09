package com.home;

import java.time.LocalTime;

public class CustomRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(String.format("from %s \tthread name: %s, time: %s", this.getClass().getSimpleName(), Thread.currentThread().getName(), LocalTime.now()));
    }
}
