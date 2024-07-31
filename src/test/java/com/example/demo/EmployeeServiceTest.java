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
    employeeService.add("ivan", "ivanov", 1000,1);
    employeeService.add("marina", "ivanova", 10000,2);
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
    Employee actual =  employeeService.find("ivan", "ivanov", 1000,1);
    assertEquals("ivan", actual.getFirstName());
    assertEquals("ivanov", actual.getLastName());

    }
    @Test
    void find_negative(){
    assertThrows(EmployeeNotFoundException.class, () ->
        employeeService.find("ivan", "ivanov",1,100));
    }
    @Test
    void remove(){
        int size = employeeService.findAll().size();
        employeeService.remove("marina","ivanova",1,100);
        assertEquals(size - 2, employeeService.findAll().size());
    }
}
