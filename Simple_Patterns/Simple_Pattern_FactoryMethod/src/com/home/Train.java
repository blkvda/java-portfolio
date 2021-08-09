package com.home;

//будут отличаться реализацией, но интерфейс у них будет общий.
public class Train implements Vehicle {
    @Override
    public void travel() {
        System.out.println("Travel by train");
    }
}
