package com.home;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private String notification;
    private List<Observer> clients = new ArrayList<>();

    public void addClient(Observer client){
        clients.add(client);
    }

    public void removeClient(Observer client){
        clients.remove(client);
    }

    public void setNotification(String notification){
        this.notification = notification;
        for (Observer client : clients) {
            client.update(notification);
        }
    }
}
