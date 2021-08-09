package com.home;

public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee.Builder().setName("Adam").setSurname("White").setAge(22).build();
        Employee employee2 = new Employee.Builder().setYearsOfExp(2).setAge(25).setName("Bob").setSurname("Black").build();

        System.out.println(employee1);
        System.out.println(employee2);
    }
}
