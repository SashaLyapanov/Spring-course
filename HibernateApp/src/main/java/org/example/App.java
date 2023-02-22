package org.example;


import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.List;

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

            //Получаем список людей, у которыйх возраст больше 20
            List<Person> people1 = session.createQuery("FROM Person WHERE age > 20").getResultList();
            //Получаем список людей, у которых имя начинается на S
            List<Person> people2 = session.createQuery("FROM Person WHERE name LIKE 'S%'").getResultList();
            //Выполняем обновление всех людей, у которых возраст больше 20 (теперь у них имя Test)
            session.createQuery("update Person set name='TestName' where age > 20").executeUpdate();
            List<Person> people3 = session.createQuery("FROM Person WHERE name = 'TestName'").getResultList();

            //Удаление записей из БД
            session.createQuery("DELETE FROM Person WHERE name = 'TestName'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Список людей, у которых возраст больше 20");
            for (Person person: people1) {
                System.out.println(person);
            }

            System.out.println("Список людей, у которых имя начинается на S");
            for(Person person: people2) {
                System.out.println(person);
            }

            System.out.println("Список людей, у которых возраст больше 20, но после редактирования их имени на TestName");
            for(Person person: people3) {
                System.out.println(person);
            }
        }

        finally {
            sessionFactory.close();
        }


    }
}
