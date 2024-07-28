package com.example.demo;

import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    EmployeeServiceImpl employeeService;
    @InjectMocks
    DepartmentService departmentService;
    @Test
    void test(){
        Mockito.when(employeeService.findAll()).thenReturn(List.of(
                new Employee("ivan","ivanov"),
                new Employee("ivan","ivanov"),
                new Employee("ivan","ivanov")
        ));
    }
}
