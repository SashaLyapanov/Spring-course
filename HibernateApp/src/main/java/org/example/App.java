package org.example;


import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //Указываем конфигурацию для хибернейта. Также эта конфигурация автоматически прочитала конфигурационный файл hibernate.properties
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Person person1 = new Person("Tigran", 20);
            Person person2 = new Person("Alina", 20);
            Person person3 = new Person("Senya", 21);
            session.beginTransaction();

            session.save(person1);
            session.save(person2);
            session.save(person3);

            session.getTransaction().commit();
        }

        finally {
            sessionFactory.close();
        }


    }
}
