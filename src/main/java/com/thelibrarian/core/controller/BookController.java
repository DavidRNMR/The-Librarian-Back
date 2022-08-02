package com.thelibrarian.core.controller;

import com.thelibrarian.integration.dto.BookDataDto;
import com.thelibrarian.integration.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping(value = "/get")
    public void getBook() {
        bookService.getBook();
    }

    @GetMapping(value = "/getByTitleAuthor/{title}/{author}")
    public ResponseEntity<BookDataDto> getBookByTitleAuthor(@PathVariable String title, @PathVariable String author) {
        if (bookService.searchBookByTitleAuthor(title, author) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(bookService.searchBookByTitleAuthor(title, author));
    }


    @GetMapping(value = "/searchByIsbn/{isbn}")
    public ResponseEntity<BookDataDto> getBookByIsbn( @PathVariable String isbn ) {

        BookDataDto checkDto = bookService.getBookByIsbn(isbn);

        if(checkDto == null){

            return ResponseEntity.notFound().build();

        }else{

            return ResponseEntity.ok().body(checkDto);

        }


    }

}
