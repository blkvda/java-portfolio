package com.home;

public class Client implements Observer {
    private String name;
    private String notification;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        this.notification = msg;
        System.out.println(String.format("Notification for '%s': = %s", name, notification));
    }
}
