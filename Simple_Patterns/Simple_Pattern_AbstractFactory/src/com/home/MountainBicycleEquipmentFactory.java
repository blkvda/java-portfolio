package com.home;

public class MountainBicycleEquipmentFactory implements BicycleEquipmentFactory {
    @Override
    public Bicycle createBicycle() {
        return new Bicycle(){
            public String getBicycleInfo(){
                return "Mountain bicycle";
            }
        };
    }

    @Override
    public Helmet createHelmet() {
        return new Helmet(){
            public String getHelmetInfo(){
                return "Helmet for mountain bicycle";
            }
        };
    }
}
