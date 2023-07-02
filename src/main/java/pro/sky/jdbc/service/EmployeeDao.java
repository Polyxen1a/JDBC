package pro.sky.jdbc.service;

import pro.sky.jdbc.model.Employee;

import java.util.List;


public interface EmployeeDao {
    void add(Employee employee);

    Employee getById(int id);

    List<Employee> getAllEmployee();

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);
}
