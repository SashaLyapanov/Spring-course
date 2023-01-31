package ru.sasha.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.sasha.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //Метод, возвращающий всех людей из БД
    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    //Метод, возвращающий чела по ID
    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id = ?", new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);
    }


    //Метод добавления человека в список
    public void save(Person person) {
        // можно так написать, т.к. метод update поддерживает внесение множества аргументов, которые будут рассмотрены, как массив данных, которые неободимо вставить
        jdbcTemplate.update("INSERT INTO Person VALUES(1, ?, ?, ?, ?)", person.getName(), person.getSurname(), person.getAge(), person.getEmail());

    }

    //Метод для изменения данных человека
    public void update(int id, Person updatePerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, surname=?, age=?, email=? WHERE id=?", updatePerson.getName(), updatePerson.getSurname(),
                updatePerson.getAge(), updatePerson.getEmail(), id);
    }


    //Метод удаления человека
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}
