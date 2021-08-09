package com.home;

public class Vehicle {
    private static int counter = 0;
    private int id;
    private String name;
    private int wheels;
    private int price;

    public Vehicle(String name, int wheels, int price) {
        this();
        this.name = name;
        this.wheels = wheels;
        this.price = price;
    }

    private Vehicle(){
        id = counter;
        counter++;
    }

    //хэш используется, например при работе с коллекциями,
    //основанными на хэшах (HashMap, HashTable), для сортировки и поиска
    //Если хешы разные, то и входные объекты гарантированно разные.
    //Если хешы равны, то входные объекты не всегда равны.
    @Override
    public int hashCode() {
        return id;
    }

    //используется для сравнения объектов (по умолчанию Object сравнивает ссылки)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //если ссылается на один и тот же объект
        if (o == null || getClass() != o.getClass()) return false; //если null или разные классы
        Vehicle vehicle = (Vehicle) o;  //т.к. класс одинаковый, то приводим к односу классу
        return id == vehicle.id;//сравниваем необходимые поля
    }

    //Возвращает строку - описание объекта
    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wheels=" + wheels +
                ", price=" + price +
                '}';
    }

    //вызывается лишь непосредственно перед сборкой мусора
    //может вообще не вызваться -> не стоит расчитывать на него
    @Override
    protected void finalize() throws Throwable {
        //Джошуа Блох
        //1. finalize() можно использовать только в двух случаях:
        //1.1. Проверка/подчистка ресурсов с логированием
        //1.2. При работе с нативным кодом, который не критичен к утечке ресурсов
        //2. finalize() замедляет работу GC по очистке объекта в 430 раз
        //3. finalize() может быть не вызван
    }
}
