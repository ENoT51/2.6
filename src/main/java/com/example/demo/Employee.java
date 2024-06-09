package com.example.demo;

import java.util.Objects;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String secondName;

    public Employee(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() !=o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName == employee.firstName && secondName == employee.secondName;
    }
    @Override
    public int hashCode(){
        return Objects.hash(firstName, secondName);
    }

    @Override
    public String toString(){
        return "Ф.И. " + firstName + " " + secondName ;
    }
}


