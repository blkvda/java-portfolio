package com.home;

public class Main {
    public static void main(String[] args) {
	    Vehicle v1 = new Vehicle("bike", 2, 1200);
        Vehicle v2 = new Vehicle("car", 3, 3300);

        System.out.println(v1);
        System.out.println("v1 hashcode: " + v1.hashCode());
        System.out.println(v2);
        System.out.println("v2 hashcode: " + v2.hashCode());
        System.out.println("v1 equals v2: " + v1.equals(v2));
    }
}
