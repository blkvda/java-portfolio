package com.home;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int startIndex;
    private int endIndex;

    public MyCallable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public String call() throws Exception {
        int result = 0;
        for(int i = startIndex; i <= endIndex; i++){
            result += i;
        }
        return String.format("Hello from Thread [%d;%d], sum result = %d", startIndex, endIndex, result);
    }
}
