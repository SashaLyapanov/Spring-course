package org.example;


import org.example.models.Item;
import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Person person = session.get(Person.class, 2);
//            Item newItem = new Item("Robot", person);
//
//            //Т.к. Hibernate выполняет кеширование сущностей, которые он получает из БД у нас может произойти разногласие в том плане,
//            // что мы можем добавить newItem (где вторичный ключ будет правильно указан = person) в БД, но при этом у нас при новом получении
//            // сущности person из БД, которую мы уже получали мы не увидим, что у нее есть еще newItem в списке заказов, т.к. в нее был записан объект,
//            // который взялся из Кеша Hibernat'ом. Именно поэтому нам лучше делать двустороннюю связь, которая будет еще и записывать newItem в сущность person,
//            // которой мы добавили newItem. Делается эта связь в нашем случае следующим образом:
//            //Таким образом эта строка кода отвечает за изменение Кеша Hibernat'а, но при этом не трогает БД.
//            person.getItems().add(newItem);
//
//            session.save(newItem);

//            //Создание нового человека и нового заказа, который назначаем новому человеку
//            Person person1 = new Person("Sergey", 21);
//            Item newItem = new Item("Computer", person1);
//
//            person1.setItems(new ArrayList<>(Collections.singletonList(newItem)));
//
//            session.save(person1);
//            session.save(newItem);

//            //Удаление всех товаров у определенного человека
//            Person person3 = session.get(Person.class, 3);
//            List<Item> items = person3.getItems();
//            for(Item item: items) {
//                session.remove(item);
//            }
            //Для изменения кэша
//            person3.getItems().clear();
//            System.out.println(person3.getItems());


            session.getTransaction().commit();

        } finally {
            session.close();
        }

    }
}
