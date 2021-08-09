package com.home;

import java.time.LocalDateTime;

//условный конфигрутор приложения, определяющий необходимую фабрику
public class AppConfigurator {
    //в данном случае в зависимости от времени (секунды)
    private static LocalDateTime localDateTime;
    private static BicycleEquipmentFactory bicycleEquipmentFactory;
    static {
        localDateTime = LocalDateTime.now();
        if(localDateTime.getSecond() % 2 == 0){
            bicycleEquipmentFactory = new MountainBicycleEquipmentFactory();
        }
        else{
            bicycleEquipmentFactory = new CityBicycleEquipmentFactory();
        }
    }

    public static BicycleEquipmentFactory getBicycleEquipmentFactory() {
        return bicycleEquipmentFactory;
    }
}
