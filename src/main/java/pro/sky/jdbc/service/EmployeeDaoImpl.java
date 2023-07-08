package pro.sky.jdbc.service;

import org.hibernate.Session;
import pro.sky.jdbc.model.Employee;

import javax.transaction.*;
import java.util.List;



public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public Integer add(Employee employee) {
        Integer id;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = (Transaction) session.beginTransaction();
            id = (Integer) session.save(employee);
            transaction.commit();
        } catch (HeuristicRollbackException e) {
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        } catch (HeuristicMixedException e) {
            throw new RuntimeException(e);
        } catch (RollbackException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    @Override
    public Employee getById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Employee").list();
        }
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = (Transaction) session.beginTransaction();
            employee.setId(id);
            session.update(employee);
            transaction.commit();
        } catch (HeuristicRollbackException e) {
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        } catch (HeuristicMixedException e) {
            throw new RuntimeException(e);
        } catch (RollbackException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployee(int id) {

    }

    @Override
    public void deleteEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = (Transaction) session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        } catch (HeuristicRollbackException e) {
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        } catch (HeuristicMixedException e) {
            throw new RuntimeException(e);
        } catch (RollbackException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Employee e) {
    }
}


