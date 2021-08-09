package utils;

import entities.AEntity;
import entities.BEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration hibernateConfiguration = new Configuration();

            // Hibernate settings equivalent to hibernate.cfg.xml's properties
            Properties hibernateProperties = new Properties();
            hibernateProperties.put(Environment.DRIVER, "org.h2.Driver");
            hibernateProperties.put(Environment.URL, "jdbc:h2:mem:test");
            hibernateProperties.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
            hibernateProperties.put(Environment.HBM2DDL_AUTO, "update");

            hibernateConfiguration.setProperties(hibernateProperties);
            hibernateConfiguration.addAnnotatedClass(AEntity.class);
            hibernateConfiguration.addAnnotatedClass(BEntity.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(hibernateConfiguration.getProperties()).build();

            sessionFactory = hibernateConfiguration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}
