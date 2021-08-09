package com.home;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        if(name == null || name.length() == 0 || name.trim() == ""){
            throw new IllegalArgumentException("'name' parameter = illegal argument");
        }
        if(age <= 0){
            throw new IllegalArgumentException("'age' parameter = illegal argument (<=0)");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
