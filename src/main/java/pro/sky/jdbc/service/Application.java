package pro.sky.jdbc.service;

import pro.sky.jdbc.model.Employee;

import java.sql.SQLOutput;

public class Application {
    public static void main(String[] args) {
        Employee employee = new Employee(11, "Richard", "Johnson", "m", 48, 1);
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        employeeDao.getAllEmployee().forEach(System.out::println);
        Integer employeeId = employeeDao.add(employee);
        System.out.println(employeeDao.getAllEmployee());
        System.out.println();
        employeeDao.updateEmployee(employee, employeeId);
        employeeDao.deleteEmployee(employeeDao.getById(employeeId));

        System.out.println(employeeDao.getById(1));
    }
}
