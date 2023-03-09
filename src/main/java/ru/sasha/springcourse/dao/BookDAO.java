package ru.sasha.springcourse.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.sasha.springcourse.models.Book;

import java.util.List;

@Component
public class BookDAO {

    private final SessionFactory sessionFactory;
    @Autowired
    public BookDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

    //Метод для вывода всех книг
    public List<Book> allBooks() {
        return null;
    }

    //Метод для вывода книги по id
    public Book showBookToId(int id) {
        return null;
    }

    //Метод лдя вывода книги по названию
    public Book showBookToName(String name) {
        return null;
    }

    //Метод для изменения книги
    public void update(int id, Book newBook) {

    }

    //Метод для создания книги
    public void create(Book book) {

    }

    //Метод для удаления книги по id
    public void delete(int id) {

    }

    //Метод для получения списка книг у определенного пользователя
    public List<Book> personBook(int personId) {
        return null;
    }

    //Метод для изменения читателя у книги (personId)
    public void updatePersonInBook(int bookId, int personId) {

    }

    //Метод для освобождения книги (personId = null)
    public void freeBook(int id) {
     
    }


}
