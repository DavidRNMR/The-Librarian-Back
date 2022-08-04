package com.thelibrarian.core.controller;

import com.thelibrarian.integration.dto.BookDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControllerApi {

    @Autowired
    BookServiceImpl bookService;


    @GetMapping(value = "/get")
    public ResponseEntity<BookDataDto> getBook() {

        return bookService.getRandomBooks();

    }


    @GetMapping(value = "/getByTitleAuthor/{title}/{author}")
    public ResponseEntity<BookDataDto> getBookByTitleAuthor(@PathVariable String title, @PathVariable String author) {

        return bookService.searchBookByTitleAuthor(title, author);

    }


    @GetMapping(value = "/searchByIsbn/{isbn}")
    public ResponseEntity<BookDataDto> getBookByIsbn(@PathVariable String isbn) {

        return bookService.getBookByIsbn(isbn);

    }


    @GetMapping("/author/{author}")
    public ResponseEntity<BookDataDto> findByAuthor(@PathVariable String author) {

        return bookService.getBookByAuthor(author);

    }

    @GetMapping(value = "searchByTitle/{title}")
    public ResponseEntity<BookDataDto> findByTitle(@PathVariable String title) {

        return bookService.getBookByTitle(title);

    }

}
