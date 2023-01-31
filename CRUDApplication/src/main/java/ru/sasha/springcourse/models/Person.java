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

    @Positive(message = "Your age is not allowed")
    private int age;

    @NotEmpty(message = "Email should not be empty!")
    @Email(message = "Email should be valid")
    private String email;

    //Пустой конструктор
    public Person() { }

    //Нормальный конструктор
    public Person(int id, String name, String surname, int age, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email= email;
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

}
