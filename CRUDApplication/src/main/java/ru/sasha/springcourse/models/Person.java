package ru.sasha.springcourse.models;

import javax.validation.constraints.*;
import java.util.Calendar;

public class Person {
    private int id;
    @NotEmpty(message="Поле 'Имя' не может быть пустым")
    @Size(min=2, max=30, message = "Имя должно содержать от 2 до 30 символов")
    private String name;

    @NotEmpty(message="Поле 'Фамилия' не может быть пустым")
    @Size(min=2, max=30, message = "Фамилия должна содержать от 2 до 30 символов")
    private String surname;

    @NotEmpty(message="Поле 'Отчество' не может быть пустым")
    @Size(min=2, max=30, message = "Отчество должно содержать от 2 до 30 символов")
    private String patronymic;

    @NotEmpty(message="Поле 'Email' не может быть пустым")
    @Email(message = "Email должен соответствовать стандартам")
    private String email;

    @Min(value = 1900, message = "Значение должно быть больше 1900")
    private int birthdayDate;


    public Person() {}

    public Person(int id, String name, String surname, String patronymic, String email, int birthdayDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.email = email;
        this.birthdayDate = birthdayDate;
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

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public int getBirthdayDate() {
        return birthdayDate;
    }
    public void setBirthdayDate(int birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

}
