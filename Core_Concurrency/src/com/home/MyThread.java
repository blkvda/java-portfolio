package com.home;

public class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        if(name == null || name.trim().length() == 0){
            name = "anonymous";
        }
        else{
            this.name = name;
        }
    }

    @Override
    public void run() {
        System.out.println(this.getClass().getSimpleName() + " running. Hello, " + name);
    }
}
