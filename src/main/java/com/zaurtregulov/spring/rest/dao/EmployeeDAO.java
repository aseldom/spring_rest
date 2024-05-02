package com.zaurtregulov.spring.rest.dao;


import com.zaurtregulov.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployee();

    Employee saveEmployee(Employee employee);

    Employee getEmployee(int id);

    int deleteEmployee(int id);

}
