package com.home;

//создание продуктов не является единственной функцией создателя. Обычно он содержит и другой полезный код работы с продуктом.
public abstract class VehicleCreator {
    void greeting(){;
        System.out.println("Greeting from vehicle creator");
    }
    //фабричный метод объявляют абстрактным, чтобы заставить все подклассы реализовать его по-своему.
    // Но он может возвращать и некий стандартный продукт.
    abstract Vehicle createVehicle();
}
