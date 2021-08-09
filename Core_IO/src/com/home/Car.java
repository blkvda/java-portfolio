package com.home;

import java.io.Serializable;

public class Car implements Serializable {
    //static поля не сериализуются
    //serialVersionUID - исп. для контроля версии, рекомендуется указывать самостоятельно, а не полагаться на компилятор
    private static final long serialVersionUID = 1L;
    private String name;
    private int yearOdIssue;
    //transient поле не учитывается при де/сериализации
    transient private int currentGPScoord;

    public Car(String name, int yearOdIssue, int currentGPScoord) {
        this.name = name;
        this.yearOdIssue = yearOdIssue;
        this.currentGPScoord = currentGPScoord;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", yearOdIssue=" + yearOdIssue +
                ", currentGPScoord=" + currentGPScoord +
                '}';
    }
}
