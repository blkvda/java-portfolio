package com.home;

import java.util.concurrent.atomic.AtomicInteger;

public class Storage {
    private static AtomicInteger countOfSessions = new AtomicInteger(0);

    public static AtomicInteger getCountOfSessions() {
        return countOfSessions;
    }
}
