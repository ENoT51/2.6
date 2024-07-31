package com.example.demo.service;

import com.example.demo.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    public double getEmployeeSalarySum(int department){
        return employeeService.findAll().stream().filter(e -> e.getDepartment()== department)
                .mapToDouble(Employee::getSalary).sum();
    }
    public Employee getMaxSalary(int department){
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }
    public Employee getMinSalary(int department){
       return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }
    public List<Employee> getEmployee(int department){
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment()==department)
                .toList();
    }
    public Map<Integer,List<Employee>> getAll(){
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
