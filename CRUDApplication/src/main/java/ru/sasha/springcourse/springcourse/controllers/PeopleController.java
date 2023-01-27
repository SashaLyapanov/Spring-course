package ru.sasha.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sasha.springcourse.dao.PersonDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.sasha.springcourse.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final  PersonDAO personDAO;
    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
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
    public String newPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "people/new";
    }


    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        personDAO.save(person);

        return "redirect:/people";
    }

}
