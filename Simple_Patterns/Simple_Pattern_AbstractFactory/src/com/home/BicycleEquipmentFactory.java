package com.home;

//общий интерфейс фабрики, который содержит методы создания всех продуктов семейства
public interface BicycleEquipmentFactory {
    Bicycle createBicycle();
    Helmet createHelmet();
}
