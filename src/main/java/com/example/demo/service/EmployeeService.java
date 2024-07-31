package com.example.demo.service;

import com.example.demo.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, double salary, int department);
    Employee remove(String firstName, String lastName, double salary, int department);
    Employee find(String firstName, String lastName, double salary, int department);

    Collection<Employee> findAll();
}
