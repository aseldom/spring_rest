package com.zaurtregulov.spring.rest.service;

import com.zaurtregulov.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee saveEmployee(Employee employee);

    Employee getEmployee(int id);

    int deleteEmployee(int id);
}
