package com.home;

public interface NumberSupplier<T extends Number> {
    T get();
}
