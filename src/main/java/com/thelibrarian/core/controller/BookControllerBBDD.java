/*
package com.thelibrarian.core.controller;

import com.thelibrarian.data.entity.BookEntity;
import com.thelibrarian.data.service.BookServiceBBDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    public class BookControllerBBDD {

    @Autowired
    BookServiceBBDD bookService;

    @GetMapping("/getAll")
    public List<BookEntity> findAll() {
        return bookService.findAll();
    }


    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody BookEntity book) {
         bookService.save(book);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookEntity> Update (@RequestBody BookEntity book, @PathVariable Long id){
        BookEntity book1 = bookService.Update(book,id);

            return  ResponseEntity.ok().body(book1);
        }
}
*/
