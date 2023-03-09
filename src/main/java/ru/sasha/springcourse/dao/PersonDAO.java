package ru.sasha.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.sasha.springcourse.models.Person;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //Метод для вывода всех человек
    @Transactional(readOnly = true)
    public List<Person> allPerson() {
        Session session = sessionFactory.getCurrentSession();

        //Здесь обычный Hibernate код
        List<Person> people = session.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        return people;
    }

    //Метод для чтения человека по Email
    @Transactional(readOnly = true)
    public Optional<Person> personToEmail(String email) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("SELECT p FROM Person p WHERE p.email = email").stream().findAny();
    }

    //Метод для чтения человека по ID
    @Transactional(readOnly = true)
    public Person personToId(int id) {
        Session session = sessionFactory.getCurrentSession();

        Person person = session.get(Person.class, id);
        return person;
    }

    //Метод для изменения человека по ID
    @Transactional
    public void changePerson(Person newPerson, int id) {
        Session session = sessionFactory.getCurrentSession();

        Person person = session.get(Person.class, id);
        person.setName(newPerson.getName());
        person.setSurname(newPerson.getSurname());
        person.setPatronymic(newPerson.getPatronymic());
        person.setEmail(newPerson.getEmail());
        person.setBirthdayDate(newPerson.getBirthdayDate());
    }

    //Метод для создания человека
    @Transactional
    public void create(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    //Метод для удаления человека
    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        session.remove(person);
    }

    @Transactional
    public Person personToBookId(int id) {
        return null;
    }




}
