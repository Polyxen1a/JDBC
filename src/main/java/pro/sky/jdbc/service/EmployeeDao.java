package pro.sky.jdbc.service;

import pro.sky.jdbc.model.Employee;

import java.util.List;


public interface EmployeeDao {
    Integer add(Employee employee);

    Employee getById(int id);

    List<Employee> getAllEmployee();

    Employee updateEmployee(Employee employee);

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);

    void deleteEmployee(Employee employee);

    void update(Employee e);
}