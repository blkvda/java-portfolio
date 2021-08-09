package com.home;

public class CityBicycleEquipmentFactory implements BicycleEquipmentFactory {
    @Override
    public Bicycle createBicycle() {
        return new Bicycle(){
            public String getBicycleInfo(){
                return "City bicycle";
            }
        };
    }

    @Override
    public Helmet createHelmet() {
        return new Helmet(){
            public String getHelmetInfo(){
                return "City for mountain bicycle";
            }
        };
    }
}

