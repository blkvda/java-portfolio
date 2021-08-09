package com.home.listeners;

import com.home.Storage;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(this.getClass().getSimpleName() + ": sessionCreated(), count of session = " + Storage.getCountOfSessions().addAndGet(1));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(this.getClass().getSimpleName() + ": sessionDestroyed(), count of session = " + Storage.getCountOfSessions().addAndGet(-1));

    }
}
