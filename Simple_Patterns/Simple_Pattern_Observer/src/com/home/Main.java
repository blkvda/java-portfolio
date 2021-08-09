package com.home;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        Client client1 = new Client("First");
        Client client2 = new Client("Second");
        Client client3 = new Client("Third");

        store.addClient(client1);
        store.addClient(client2);
        store.addClient(client3);
        store.setNotification("1st notification for three clients");

        store.removeClient(client2);
        store.setNotification("2nd notification for two clients");
    }
}
