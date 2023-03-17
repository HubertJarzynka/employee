package com.wrok.employee.DAO;

import com.wrok.employee.entity.Employee;

import java.util.List;


public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    int deleteById(int id);

    int save(Employee e);

    int update(Employee e, int id);

    List<Employee> findKafka();

    int savekafka(Employee e);
}

