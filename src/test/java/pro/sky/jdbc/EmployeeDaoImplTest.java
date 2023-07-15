package pro.sky.jdbc;

import org.junit.jupiter.api.AfterEach;
import org.testng.annotations.Test;
import pro.sky.jdbc.model.City;
import pro.sky.jdbc.model.Employee;
import pro.sky.jdbc.service.CityDao;
import pro.sky.jdbc.service.CityDaoImpl;
import pro.sky.jdbc.service.EmployeeDao;
import pro.sky.jdbc.service.EmployeeDaoImpl;

import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

class EmployeeDaoImplTest {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();
    private final CityDao cityDao = (CityDao) new CityDaoImpl();

    @AfterEach
    public void cleanUp() {
        cityDao.getAllCity().forEach(cityDao::deleteCity);
        assertTrue(cityDao.getAllCity().isEmpty());
        assertTrue(employeeDao.getAllEmployee().isEmpty());
    }

    @Test
    public void shouldSaveTheEmployee() {
        Employee employee = new Employee(4, "Robert", "Jordan", "m", 45, null);
        employeeDao.add(employee);
        assertTrue(employeeDao.getAllEmployee().contains(employee));
        employeeDao.deleteEmployee(employee);
        assertFalse(employeeDao.getAllEmployee().contains(employee));
    }

    @Test
public void shouldDeleteEmployee() {
        Employee employee = new Employee(4, "Robert","Jordan", "m", 45, null);
        Integer employeeId = employeeDao.add(employee);
        employee.setId(employeeId);
        employeeDao.deleteEmployee(employee);
        assertFalse(employeeDao.getAllEmployee().contains(employee));
    }

    @Test
    public void shouldSaveTheCity() {
        City city = City.builder()
                .city_name("California")
                .build();
        cityDao.add(city);
        assertTrue(cityDao.getAllCity().contains(city));
    }
    @Test
    public void shouldUpdateCity() {
        City city = City.builder()
                .city_name("California")
                .build();
        City created = cityDao.add(city);
        assertTrue(cityDao.getAllCity().contains(city));
        created.setCity_name("New York");
        cityDao.updateCity(city);
        assertEquals(cityDao.getById(created.getCity_id()).getCity_name(), "New York");
    }

    @Test
    public void shouldCreateEmployeesWhenCityUpdate() {
        City city = City.builder().city_name("Washington").employees(List.of().build();
        cityDao.add(city);
        assertTrue(cityDao.getAllCity().contains(city));
        Employee employee1 = Employee.builder()
                .first_name("Robert")
                .last_name("Jordan")
                .gender("m")
                .city(city)
                .age(45)
                .build();
        Employee employee2 = Employee.builder()
                .first_name("Robert")
                .last_name("Hunter")
                .gender("m")
                .city(city)
                .age(27)
                .build();
        city.setEmployees(List.of(employee1, employee2));

        City updatedCity = cityDao.updateCity(city);

        assertTrue(employeeDao.getAllEmployee().containsAll(updatedCity.getEmployees()));
        cityDao.getById(updatedCity.getCity_id());
    }
    private void assertEquals(String city_name, String new_york) {
    }


}
