package com.example.demo;

import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Employee;
import com.example.demo.service.EmployeeService;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping ("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
@GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                @RequestParam("salary")  double salary,
                                @RequestParam("department") int department) {
    return employeeService.add(firstName, lastName, salary, department);
}

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("salary")  double salary,
                           @RequestParam("department") int department) {
        return employeeService.add(firstName, lastName, salary, department);

    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("salary")  double salary,
                         @RequestParam("department") int department) {
        return employeeService.add(firstName, lastName, salary, department);

    }

  @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }

}
