package com.home;

public class Employee {
    private String name;
    private String surname;
    private int age;
    private int yearsOfExp;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getYearsOfExp() {
        return yearsOfExp;
    }

    public static class Builder{
        private Employee newEmploeyee;

        public Builder() {
            this.newEmploeyee = new Employee();
        }

        public Builder setName(String name){
            newEmploeyee.name = name;
            return this;
        }

        public Builder setSurname(String surname){
            newEmploeyee.surname = surname;
            return this;
        }

        public Builder setAge(int age){
            newEmploeyee.age = age;
            return this;
        }

        public Builder setYearsOfExp(int yearsOfExp){
            newEmploeyee.yearsOfExp = yearsOfExp;
            return this;
        }

        public Employee build(){
            return newEmploeyee;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "\n\tname: " + name +
                "\n\tsurname: " + surname +
                "\n\tage: " + age +
                "\n\tyearsOfExp: " + yearsOfExp + "}";
    }
}
