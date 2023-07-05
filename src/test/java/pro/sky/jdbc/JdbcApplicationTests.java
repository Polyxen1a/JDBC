package pro.sky.jdbc;

import org.testng.annotations.Test;
import pro.sky.jdbc.model.Employee;
import pro.sky.jdbc.service.EmployeeDao;
import pro.sky.jdbc.service.EmployeeDaoImpl;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;


class JdbcApplicationTests {

    private final EmployeeDao dao = new EmployeeDaoImpl();

    @Test
    public void shouldSaveTheEmployee() {
        Employee employee = new Employee(3, "Robert", "Hunter", "m", 27, 4);
        dao.add(employee);
        assertTrue(dao.getAllEmployee().contains(employee));
    }
    @Test
    public void shouldDeleteEmployee() {
        Employee employee = new Employee(3, "Robert", "Hunter", "m", 27, 4);
        Integer employeeId = dao.add(employee);
        employee.setId(employeeId);
        dao.deleteEmployee(employee);
        assertFalse(dao.getAllEmployee().contains(employee));
    }
}