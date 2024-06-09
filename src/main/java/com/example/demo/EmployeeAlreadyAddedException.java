package com.example.demo;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String massage){
        super(massage);
    }
}