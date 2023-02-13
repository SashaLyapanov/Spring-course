package ru.sasha.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.sasha.springcourse.models.Person;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Метод для вывода всех человек
    public List<Person> allPerson() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    //Метод для чтения человека по Email
    public Person personToEmail(String email) {
        return jdbcTemplate.query("SELECT * FROM person WHERE email=?", new Object[]{email}, new PersonMapper()).stream().findAny().orElse(null);
    }

    //Метод для чтения человека по ID
    public Person personToId(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", new Object[]{id}, new PersonMapper()).stream().findAny().orElse(null);
    }

    //Метод для изменения человека по ID
    public void changePerson(Person newPerson, int id) {
        jdbcTemplate.update("UPDATE person SET name=?, surname=?, patronymic=?, email=?, birthdayDate=? WHERE id=?",
                newPerson.getName(), newPerson.getSurname(), newPerson.getPatronymic(), newPerson.getEmail(), newPerson.getBirthdayDate(), id);
    }

    //Метод для создания человека
    public void create(Person person) {
        jdbcTemplate.update("INSERT INTO person(name, surname, patronymic, email, birthdayDate) VALUES (?, ?, ?, ?, ?)", person.getName(),
                person.getSurname(), person.getPatronymic(), person.getEmail(), person.getBirthdayDate());
    }

    //Метод для удаления человека
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id = ?", id);
    }

}
