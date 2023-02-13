package ru.sasha.springcourse.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.sasha.springcourse.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person();

        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setSurname(resultSet.getString("surname"));
        person.setPatronymic(resultSet.getString("patronymic"));
        person.setEmail(resultSet.getString("email"));
        person.setBirthdayDate(resultSet.getInt("birthdayDate"));

        return person;
    }
}
