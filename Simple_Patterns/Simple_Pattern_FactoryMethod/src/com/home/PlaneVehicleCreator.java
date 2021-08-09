package com.home;

public class PlaneVehicleCreator extends VehicleCreator {
    @Override
    Vehicle createVehicle() {
        return new Plane();
    }
}
