package com.example.demo;

import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    EmployeeServiceImpl employeeService;
    @InjectMocks
    DepartmentService departmentService;
    @BeforeEach
    void init(){
        when(employeeService.findAll()).thenReturn(List.of(
                new Employee("ivan","ivanov", 100_000,1 ),
                new Employee("marina","ivanova", 200_000,1 ),
                new Employee("anna","smirnova", 300_000,2 ),
                new Employee("vova","vasev", 100_000,2 )
        ));
        assertEquals(10000, departmentService.getMinSalary(1));
    }
    @Test
    void sum(){
        double actual = departmentService.getEmployeeSalarySum(1);
        assertEquals(300_000, actual);
    }
    @Test
    void min(){
        Employee actual = departmentService.getMinSalary(2);
        assertEquals(100_000, actual);
    }
    @Test
    void max(){
        double actual = departmentService.getMaxSalary(1);
        assertEquals(200_000, actual);
    }
    @Test
    void filter(){
        List<Employee> actual = departmentService.getEmployee(1);
        assertEquals(2, actual.size());
        actual.forEach(employee -> assertEquals(1, employee.getDepartment()));
    }
    @Test
    void grouped(){
        Map<Integer, List<Employee>> actual = departmentService.getAll();
        assertEquals(2, actual.keySet().size());
        for (Map.Entry<Integer, List<Employee>> entry : actual.entrySet()){
            Integer department = entry.getKey();
            List<Employee> employees = entry.getValue();
            employees.forEach(employee -> assertEquals(department, employee.getDepartment()));
        }
    }
}
