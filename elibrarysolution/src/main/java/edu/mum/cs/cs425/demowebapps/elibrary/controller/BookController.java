package edu.mum.cs.cs425.demowebapps.elibrary.controller;

import edu.mum.cs.cs425.demowebapps.elibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = {"elibrary/book/list", "book/list"})
    public ModelAndView listBooks() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("books", bookService.getBooks());
        mav.setViewName("book/list");
        return mav;
    }

}
