package com.zaurtregulov.spring.rest.controller;

import com.zaurtregulov.spring.rest.entity.Employee;
import com.zaurtregulov.spring.rest.exception_handler.NoSuchEmployeeException;
import com.zaurtregulov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee == null) {
            throw new NoSuchEmployeeException("No such employee with id = " + id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        int res = employeeService.deleteEmployee(id);
        if (res == 0) {
            throw new NoSuchEmployeeException("Employee with id: " + id + " not exist");
        }
        return "Employee with id: " + id + " was deleted";
    }

}
