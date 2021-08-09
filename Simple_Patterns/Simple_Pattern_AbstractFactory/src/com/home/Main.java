package com.home;

public class Main {
    public static void main(String[] args) {
        //Используется паттерн абстрактной фабрики
        //конкретная реализация фабрики определяется в конфигураторе (в данном случае на основании времени)
        BicycleEquipmentFactory factory = AppConfigurator.getBicycleEquipmentFactory();
        //затем конкретная реализация фабрики используется для создания объектов
        Bicycle bicycle = factory.createBicycle();
        Helmet helmet = factory.createHelmet();

        System.out.println(bicycle.getBicycleInfo());
        System.out.println(helmet.getHelmetInfo());
    }
}
