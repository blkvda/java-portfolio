package com.home;

public class SingletonOneThread {
    private static SingletonOneThread instance;
    private String value;

    private SingletonOneThread(String value){
        this.value = value;
    }

    public static SingletonOneThread getInstance(String value){
        if(instance == null){
            instance = new SingletonOneThread(value);

        }
        return instance;
    }

    public String getValue() {
        return value;
    }
}
