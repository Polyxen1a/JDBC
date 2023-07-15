package pro.sky.jdbc.service;

import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import pro.sky.jdbc.model.Employee;


public class HibernateSessionFactoryUtil {
    public static Session getSessionFactory;

    private static SessionFactory sessionFactory() {
        if (sessionFactory() == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Employee.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory();
    }

    public static SessionBuilder<SessionBuilder> getSessionFactory() {
        return null;
    }
}