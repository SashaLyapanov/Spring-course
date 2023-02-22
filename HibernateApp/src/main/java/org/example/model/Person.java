package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {

    //Аннотация Id требуется, чтобы пометить первичные ключи
    //Аннотация Column требуется, чтобы сопоставить атрибуты класса со столбцаи таблицы в БД
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    //Обязательно для всех классов, помеченных аннотацие @Entity требуется пустой конструктор, т.к. будет автоматическое создание сущнстей
    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    public String toString() {
        return this.name + ", " + this.age;
    }
}
