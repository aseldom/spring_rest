package com.zaurtregulov.spring.rest.dao;

import com.zaurtregulov.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Employee> getAllEmployee() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Employee> employees = currentSession.createQuery("from Employee", Employee.class).getResultList();
        return employees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.merge("Employee", employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        MutationQuery mutationQuery = currentSession.createMutationQuery("delete from Employee where id=:empId")
                .setParameter("empId", id);
        mutationQuery.executeUpdate();
    }
}
