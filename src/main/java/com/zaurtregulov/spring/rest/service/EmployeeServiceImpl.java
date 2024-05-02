package com.zaurtregulov.spring.rest.service;

import com.zaurtregulov.spring.rest.dao.EmployeeDAO;
import com.zaurtregulov.spring.rest.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDAO.getAllEmployee();

    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public int deleteEmployee(int id) {
        return employeeDAO.deleteEmployee(id);
    }
}
