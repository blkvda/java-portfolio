package com.home;

public class TrainVehicleCreator extends VehicleCreator{
    @Override
    Vehicle createVehicle() {
        return new Train();
    }
}
