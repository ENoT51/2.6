package com.example.demo.service;

import com.example.demo.Employee;
import com.example.demo.EmployeeAlreadyAddedException;
import com.example.demo.EmployeeNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }


    @Override
    public Employee add(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        throwIfInvalidData(employee);
        employee.setFirstName(StringUtils.capitalize(employee.getFirstName().toLowerCase()));
        employee.setLastName(StringUtils.capitalize(employee.getLastName().toLowerCase()));
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
    throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
    public static void throwIfInvalidData(Employee employee){
        if (!StringUtils.isAlpha(employee.getFirstName())||!StringUtils.isAlpha(employee.getLastName())){
            throw new InvalidDataException();
        }
    }
}
