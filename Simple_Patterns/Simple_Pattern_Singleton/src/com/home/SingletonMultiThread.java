package com.home;

public class SingletonMultiThread {
    //volatile - отключает "кэширование" переменной в каждом потоке,
    //таким образом каждый раз обращается к значению переменной в памяти
    private static volatile SingletonMultiThread instance;
    private String value;

    private SingletonMultiThread(String value){
        this.value = value;
    }

    public static SingletonMultiThread getInstance(String value){
        SingletonMultiThread result = instance;
        if(result != null){
            return result;
        }
        synchronized(SingletonMultiThread.class) {
            if (instance == null) {
                instance = new SingletonMultiThread(value);
            }
            return instance;
        }
    }

    public String getValue() {
        return value;
    }
}
