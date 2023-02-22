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
            session.beginTransaction();

            //Изменение человека в БД
//            Person person = session.get(Person.class, 2);
//            person.setName("Gena");
            //Удаление человека из БД
//            session.delete(person);

            //Получние id человека, после того, как записали его в БД
            Person person = new Person("Some Name", 30);
            session.save(person);
            System.out.println(person.getId());




            session.getTransaction().commit();
        }

        finally {
            sessionFactory.close();
        }


    }
}
