package ru.sasha.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sasha.springcourse.dao.BookDAO;
import ru.sasha.springcourse.dao.PersonDAO;
import ru.sasha.springcourse.models.Book;
import ru.sasha.springcourse.models.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDAO bookDAO;
    private final PersonDAO personDAO;
    @Autowired
    public BookController(BookDAO bookDAO, PersonDAO personDAO) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("books", bookDAO.allBooks());
        return "book/showAll";
    }

    @GetMapping("/{id}")
    public String book(@PathVariable("id") int id,
                       Model model,
                       @ModelAttribute("person")Person person) {
        model.addAttribute("book", bookDAO.showBookToId(id));
        model.addAttribute("people", personDAO.allPerson());
        model.addAttribute("personBook", personDAO.personToBookId(id));
        Book book = bookDAO.showBookToId(id);
        System.out.println(book.getPersonId());
        return "book/book";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "book/new";
    }

    @PostMapping()
    public String createBook(@ModelAttribute("book") @Valid Book book,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/new";
        }
        bookDAO.create(book);
        return "redirect:/books";
    }


    @GetMapping("/{id}/edit")
    public String toEdit(@PathVariable("id") int id,
                         Model model) {
        model.addAttribute("book", bookDAO.showBookToId(id));
        return "book/edit";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("book") @Valid Book book,
                       BindingResult bindingResult,
                       @PathVariable("id") int id) {
            if (bindingResult.hasErrors()) {
                return "book/edit";
            }
            bookDAO.update(id, book);
            return "redirect:/books";
    }

    @GetMapping("/{id}/delete")
    public String toDelete(@PathVariable("id") int id,
                           Model model) {
        model.addAttribute(bookDAO.showBookToId(id));
        return "book/delete";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/books";
    }


    //Лажа с personId, т.к. не можем получить его с формы в action
    @PostMapping("/{id}/assign")
    public String addPerson(@PathVariable("id") int bookId,
                            @ModelAttribute("person") Person selectedPerson) {
        bookDAO.updatePersonInBook(bookId, selectedPerson.getId());
//        return "redirect:/books/{" + bookId + "}";
        return "redirect:/books";
    }


    //Метод для освобождения книги от читателя
    @PatchMapping("/{id}/free")
    public String freeBook(@PathVariable("id") int id,
                           Model model) {
        bookDAO.freeBook(id);
        return "redirect:/books";
    }

}



