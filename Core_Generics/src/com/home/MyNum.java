package com.home;

public class MyNum<T extends Number> implements NumberSupplier<T> {
    private T value;

    public MyNum(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return null;
    }

    @Override
    public String toString() {
        return "MyNum{" +
                "value=" + value +
                '}';
    }
}
