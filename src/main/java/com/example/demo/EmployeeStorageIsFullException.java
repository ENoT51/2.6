package com.example.demo;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String massage) {
        super(massage);
    }
}
