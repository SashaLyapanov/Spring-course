package ru.sasha.springcourse.models;


import org.springframework.stereotype.Component;

import javax.validation.constraints.*;


public class Person {

    private int id;

    @NotEmpty(message = "Enter your name!")
    @Size(min=2, max=30, message = "Name should be between 2 and 30 characters")
    private String name;

    @NotEmpty(message = "Enter your name!")
    @Size(min=2, max=30, message = "Name should be between 2 and 30 characters")
    private String surname;

    @PositiveOrZero(message = "Your age is not allowed")
    private int age;

    @NotEmpty(message = "Email should not be empty!")
    @Email(message = "Email should be valid")
    private String email;

    //Структура адреса:
    //Страна, Город, почтовый индекск(6 цифр)
    //Россия, Владимир, 600377
    //Аннотация Pattern внедряется через использование регулярных выражений
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Адрес должен придерживаться формату: Страна, Город, индекс (6 цифр)")
    private String address;

    //Пустой конструктор
    public Person() { }

    //Нормальный конструктор
    public Person(int id, String name, String surname, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email= email;
        this.address = address;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
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

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
}
