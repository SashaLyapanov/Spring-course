package ru.sasha.springcourse.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Book {
    private int id;
    @NotEmpty(message = "Название книги не должно быть пустым")
    private String name;
    @NotEmpty(message = "Автор обязательно должен быть указан")
    private String author;
    @Min(value = 1900, message = "Год издания выше 1900")
    private int year;
    private Integer personId;

    public Book() {}

    public Book(int id, String name, String author, int year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public Integer getPersonId() {return personId;}
    public void setPersonId(Integer personId) {this.personId = personId;}


}
