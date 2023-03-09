package ru.sasha.springcourse.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.sasha.springcourse.models.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Book book = new Book();

        book.setId(resultSet.getInt("id"));
        book.setName(resultSet.getString("name"));
        book.setAuthor(resultSet.getString("author"));
        book.setYear(resultSet.getInt("year"));

        //Проверяем значение из resultSet на null
        //и если оно Null, то вписываем в personId - null
        int personId = resultSet.getInt("personId");
        if (personId == 0) {
            book.setPersonId(null);
        } else {
            book.setPersonId(resultSet.getInt("personId"));
        }

        return book;
    }
}
