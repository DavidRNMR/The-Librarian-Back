package com.thelibrarian.core.controller;

import com.thelibrarian.integration.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping(value = "/get")
    public void getBook() {
        bookService.getBook();
    }


    @GetMapping(value = "/searchByIsbn")

    public void getBookByIsbn(@RequestParam String isbn) {

        bookService.getBookByIsbn(isbn);
    }

}
