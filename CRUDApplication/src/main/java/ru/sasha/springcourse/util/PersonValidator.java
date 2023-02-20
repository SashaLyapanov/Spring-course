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
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //Выполняем downcast и приводим Object target к нужному нам объекту.
        Person person = (Person) target;

        //Смотрим, есть ли челоек с тким же email'ом в БД
        if (personDAO.show(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "",  "Проверьте email, т.к. данный email уже зарегистрирован в приложении.");
        }

    }
}
