package ru.sasha.springcourse.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sasha.springcourse.dao.PersonDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.sasha.springcourse.models.Person;
import ru.sasha.springcourse.util.PersonValidator;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;
    private final PersonValidator personValidator;

    @Autowired
    public PeopleController(PersonDAO personDAO, PersonValidator personValidator) {
        this.personDAO = personDAO;
        this.personValidator = personValidator;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        //Получим конкретного человека из DAO по id и передадим в view
        model.addAttribute("person", personDAO.show(id));
        return "people/person";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }


    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) throws SQLException {
        //bindingResult - Это объект, в который мы записываем и храним все ошибки валидаций (как с формы, так и с personValidator
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            return "people/new";
        }

        personDAO.save(person);

        return "redirect:/people";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        //Проверка person на валидацию email'а через personValidator
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws SQLException {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
