package ru.sasha.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.sasha.springcourse.models.Book;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    //Метод для вывода всех книг
    public List<Book> allBooks() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>());
    }

    //Метод для вывода книги по id
    public Book showBookToId(int id) {
        return jdbcTemplate.query("SELECT * FORM book WHERE id=?", new Object[]{id}, new BookMapper()).stream().findAny().orElse(null);
    }

    //Метод лдя вывода книги по названию
    public Book showBookToName(String name) {
        return jdbcTemplate.query("SELECT * FROM book WHERE name=?", new Object[]{name}, new BookMapper()).stream().findAny().orElse(null);
    }

    //Метод для изменения книги
    public void update(int id, Book newBook) {
        jdbcTemplate.update("UPDATE book SET name=?, author=?,year=? WHERE id=?", newBook.getName(), newBook.getAuthor(), newBook.getYear(), id);
    }

    //Метод для создания книги
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO book (name, author, yaer) VALUES (?, ?, ?)", book.getName(), book.getAuthor(), book.getYear());
    }

    //Метод для удаления книги по id
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }
}
