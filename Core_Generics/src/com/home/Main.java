package com.home;

import com.home.Planes.Boeing;
import com.home.Planes.Plane;
import com.home.Vehicles.Car;

public class Main {
    public static void main(String[] args) {
        //Remember PECS: "Producer Extends, Consumer Super".
        //"Producer Extends" - If you need a List to produce T values (you want to read Ts from the list), you need to declare it with ? extends T, e.g. List<? extends Integer>. But you cannot add to this list.
        //"Consumer Super" - If you need a List to consume T values (you want to write Ts into the list), you need to declare it with ? super T, e.g. List<? super Integer>. But there are no guarantees what type of object you may read from this list.
        //If you need to both read from and write to a list, you need to declare it exactly with no wildcards, e.g. List<Integer>.
        Storage<?,Transport> transportStorage = new Storage<>(new MyNum<>(0));
        Storage<?,Plane> planesStorage = new Storage<>(new MyNum<>(1));
        Storage<?,Car> carsStorage = new Storage<>(new MyNum<>((short)2));

        transportStorage.setElement(new Transport());
        planesStorage.setElement(new Boeing("MyBoeing"));
        carsStorage.setElement(new Car("MyFirstCar"));

        System.out.println(transportStorage);
        System.out.println(planesStorage);
        System.out.println(carsStorage);
    }
}
