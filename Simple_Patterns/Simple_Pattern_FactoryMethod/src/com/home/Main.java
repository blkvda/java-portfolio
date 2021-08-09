package com.home;

import java.time.LocalDateTime;

public class Main {
    private static VehicleCreator vehicleCreator;

    public static void main(String[] args) {
        initialize();
        vehicleCreator.greeting();
        vehicleCreator.createVehicle().travel();
    }

    private static void initialize(){
        LocalDateTime localDateTime = LocalDateTime.now();
        if(localDateTime.getSecond() % 2 == 0){
            vehicleCreator = new TrainVehicleCreator();
        }
        else{
            vehicleCreator = new PlaneVehicleCreator();
        }
    }
}
