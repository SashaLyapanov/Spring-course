package ru.sasha.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sasha.springcourse.dao.PersonDAO;
import ru.sasha.springcourse.models.Person;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final PersonDAO personDAO;

    @Autowired
    public AdminController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String AdminPage(Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("people", personDAO.index());

        return "admin/adminPage";
    }

    @PatchMapping("/add")
    public String addAdmin(@ModelAttribute("person") Person person) {
        return "redirect:/people";
    }

}
