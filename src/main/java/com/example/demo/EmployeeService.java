package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
    public class EmployeeService  {
    private final int STORAGE_SIZE = 6;
    private final List<Employee> employees = new ArrayList<>(List.of(new Employee("Petr", "Petrov"),
    new Employee("Ivan", "Ivanov"), new Employee("Sara", "Smirnova"), new Employee(" Jonh", "Smith"),
    new Employee("Sam", "Jackson")
    ));

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException("Список полностью заполнен");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен в список");
        }
        employees.add(employee);
        return employee;
    }

    public Employee remove(String firstName, String lastName) {
        Employee employeeTo = new Employee(firstName, lastName);
        if (!employees.contains(employeeTo)) {
            throw new EmployeeNotFoundException("Удаляемый сотрудник не найден");
        }
        employees.remove(employeeTo);
        return null;
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;}
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }



    public List<Employee> getAll() {
        return employees;
    }

}
