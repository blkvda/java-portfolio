package com.home;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(this.getClass().getSimpleName() + " running");
    }
}
