package com.example.demo.service;

import com.example.demo.Employee;
import com.example.demo.EmployeeAlreadyAddedException;
import com.example.demo.EmployeeNotFoundException;
import com.example.demo.EmployeeStorageIsFullException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;
    static final int EMPLOYEES_MAX = 10;
    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }


    @Override
    public Employee add(String firstName, String lastName, double salary, int department    ) {

        String capFirstName = StringUtils.capitalize(firstName);
        String capLastName = StringUtils.capitalize(lastName);
        Employee employee = new Employee(capFirstName, capLastName, salary, department);
        if (employees.containsKey(capFirstName + capLastName)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < EMPLOYEES_MAX) {
            employees.put(capFirstName + capLastName, employee);
            return employee;
        } else{
            throw new EmployeeStorageIsFullException();}
    }

    @Override
    public Employee remove (String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
            if (employees.containsKey(firstName + lastName)) {
                employees.remove(employee.getFirstName() + employee.getLastName());
                return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
        public Employee find(String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
            if (employees.containsKey(firstName + lastName)) {
                return employee;
            }
            throw new EmployeeNotFoundException();
        }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}



