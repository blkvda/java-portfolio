package com.home;

public class Main {

    public static void main(String[] args) {
        System.out.println("SingletonOneThread");
	    SingletonOneThread singleton1 = SingletonOneThread.getInstance("first");
        System.out.println("SingletonOneThread: " + singleton1.getValue());
	    SingletonOneThread singleton2 = SingletonOneThread.getInstance("second");
        System.out.println("SingletonOneThread: " + singleton2.getValue());

        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }

    static class Thread1 implements Runnable{
        @Override
        public void run() {
            SingletonMultiThread singletonMulti1 = SingletonMultiThread.getInstance("Multi first");
            System.out.println("Thread1: " + singletonMulti1.getValue());
        }
    }
    static class Thread2 implements Runnable{
        @Override
        public void run() {
            SingletonMultiThread singletonMulti1 = SingletonMultiThread.getInstance("Multi second");
            System.out.println("Thread2: " + singletonMulti1.getValue());
        }
    }

}
