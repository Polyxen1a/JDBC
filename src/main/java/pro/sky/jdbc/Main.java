package pro.sky.jdbc;
import pro.sky.jdbc.model.Employee;
import pro.sky.jdbc.service.EmployeeDao;
import pro.sky.jdbc.service.EmployeeDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EmployeeDao dao = new EmployeeDaoImpl();
        Employee e = dao.getById(1);
        e.setLast_name("Тест");
        dao.update(e);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = entityManager.find(Employee.class, 1);
        System.out.println(employee);

        entityManager.close();
        entityManagerFactory.close();
    }
}