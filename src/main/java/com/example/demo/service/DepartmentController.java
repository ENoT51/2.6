package com.example.demo.service;

import com.example.demo.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMax(int departmentId){
    return departmentService.getMaxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee getMin(int departmentId){
        return departmentService.getMinSalary(departmentId);
    }
    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> getAll(int departmentId){
        return departmentService.getEmployee(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer,List<Employee>> getAll(){
        return departmentService.getAll();
    }
    @GetMapping("/sum")
    public double getSum(int departmentId){
        return departmentService.getEmployeeSalarySum(departmentId);
    }

}
