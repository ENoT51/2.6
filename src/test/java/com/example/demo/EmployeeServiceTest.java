package com.example.demo;

import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceTest {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
@BeforeEach
void init(){
    employeeService.add("acv", "asc");
    employeeService.add("abca", "ascva");
}
@AfterEach
void clear(){
    employeeService = new EmployeeServiceImpl();
}
    @Test
    void findAll(){
        Collection<Employee> actual = employeeService.findAll();
        assertEquals(2, actual.size());
    }
    @Test
    void find(){
    Employee actual =  employeeService.find("ivan", "ivanov");
    assertEquals("ivan", actual.getFirstName());

    }
    @Test
    void find_negative(){
    assertThrows(EmployeeNotFoundException.class, () ->
        employeeService.find("sergei", "sergeev"));
    }
    @Test
    void remove(){
        int size = employeeService.findAll().size();
        employeeService.remove("ivan","ivanov");
        assertEquals(size - 1, employeeService.findAll().size());
    }
}
