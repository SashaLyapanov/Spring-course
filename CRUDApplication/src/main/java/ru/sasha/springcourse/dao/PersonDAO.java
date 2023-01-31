package ru.sasha.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
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



    ////////////////////////////////////////////////////////////////////////////////////
    //Тестируем производительность пакетной вставки Batch Update
    ////////////////////////////////////////////////////////////////////////////////////

    //метод, демонстрирующий вставку 1000 записей в таблицу БД отдельными запросами
    public void testMultipleUpdate() {
        List<Person> people = create1000Peopple();

        long before = System.currentTimeMillis();

        for (Person person: people) {
            jdbcTemplate.update("INSERT INTO Person VALUES(?, ?, ?, ?, ?)", person.getId(), person.getName(), person.getSurname(), person.getAge(), person.getEmail());
        }

        long after = System.currentTimeMillis();
        System.out.println("Time insert without batch update: " + (after-before));
    }

    //метод, демонстрирущий ставку в таблицу БД с помощью пакетного обновления (Batch update)
    public void testBatchUpdate() {
        List<Person> people = create1000Peopple();
        long before = System.currentTimeMillis();

        jdbcTemplate.batchUpdate("INSERT INTO Person VALUES (?, ?, ?, ?, ?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, people.get(i).getId());
                preparedStatement.setString(2, people.get(i).getName());
                preparedStatement.setString(3, people.get(i).getSurname());
                preparedStatement.setInt(4,people.get(i).getAge());
                preparedStatement.setString(5, people.get(i).getEmail());
            }

            @Override
            public int getBatchSize() {
                return people.size();
            }
        });

        long after = System.currentTimeMillis();
        System.out.println("Time insert with Batch Update: " + (after - before));
    }


    //метод, создающий список из 1000 человек
    public List<Person> create1000Peopple() {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i<1000; i++) {
            people.add(new Person(i, "Name"+i, "Surname" +i, 30, "test" + i + "mail.ru" ));
        }

        return people;
    }
}
