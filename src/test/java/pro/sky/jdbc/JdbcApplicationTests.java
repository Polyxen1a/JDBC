package pro.sky.jdbc;

import org.junit.jupiter.api.Test;
import pro.sky.jdbc.model.Employee;
import pro.sky.jdbc.service.EmployeeDao;
import pro.sky.jdbc.service.EmployeeDaoImpl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JdbcApplicationTests {

    private final EmployeeDao dao = EmployeeDaoImpl();

    @Test
    public void shouldSaveTheEmployee() {
        Employee employee = new Employee(3, Robert, Hunter, m, 27, 4);
        dao.add(employee);
        assertTrue(dao.getAllEmployee().contains(employee));
    }
    @Test
    public void shouldDeleteEmployee() {
        Employee employee = new Employee(3, Robert, Hunter, m, 27, 4);
        Integer employeeId = dao.add(employee);
        employee.setId(employeeId);
        dao.deleteEmployee(employee);
        assertFalse(dao.getAllEmployee().contains(employee));
    }
}
