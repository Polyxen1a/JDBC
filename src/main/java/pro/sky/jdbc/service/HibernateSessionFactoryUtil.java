package pro.sky.jdbc.service;

import org.apache.catalina.core.StandardService;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBouider;
import org.hibernate.cfg.Configuration;
import pro.sky.jdbc.model.Employee;


public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory() {
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Employee.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory();
    }
}
