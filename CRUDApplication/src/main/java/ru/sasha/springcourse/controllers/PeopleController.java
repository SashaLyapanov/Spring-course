package ru.sasha.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sasha.springcourse.dao.PersonDAO;
import ru.sasha.springcourse.models.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonDAO personDAO;
    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String people(Model model) {
        model.addAttribute("people", personDAO.allPerson());
        return "people/showAll";
    }


    @GetMapping("/{id}")
    public String person (@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.personToId(id));
        return "/people/person";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {return "people/new";}


    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/new";
        }

        personDAO.create(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.personToId(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }
        personDAO.changePerson(person, id);
        return "redirect:/people";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.personToId(id));
        return "people/delete";
    }

    @DeleteMapping("/{id}")
    public String delete1(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }


}
