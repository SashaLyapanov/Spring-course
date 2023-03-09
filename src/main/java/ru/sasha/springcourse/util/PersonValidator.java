package ru.sasha.springcourse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.sasha.springcourse.dao.PersonDAO;
import ru.sasha.springcourse.models.Person;

@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        //Проверка на то, что данный класс валидатор работает именно на Person.class (проверка идет через сравнение clazz и Person.class
        return Person.class.equals(clazz);
    }

    //Метод, который вызывается в контроллере для валидации того человека, который приходит с формы в методах.
    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        //Смотрим, есть ли человек с таким email'ом в БД (валидация по Unique)
        if (personDAO.personToEmail(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "Данный email уже используется в системе");
        }
    }
}
