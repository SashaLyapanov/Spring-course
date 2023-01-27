package ru.sasha.springcourse.dao;

import ru.sasha.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {
    //На первой стадии не используем БД, а просто генерируем список, т.к. быстрее понять суть и легче (без SQL).
    //Список людей
    private static int PEOPLE_COUNT = 0;
    private List<Person> people;


    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Sasha", "Lyapanov", "sasha@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Nikita", "Shilov", "nikita@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Alina", "Belova", "alina@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Tigran", "Melkonyan", "tigran@mail.ru"));
    }


    //Метод, возвращающий всех людей из БД
    public List<Person> index() {
        return people;
    }

    //Метод, возвращающий чела по ID
    public Person show(int id) {
        //Использование лямбда выражений
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }


    //Метод добавления человека в список
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

}
