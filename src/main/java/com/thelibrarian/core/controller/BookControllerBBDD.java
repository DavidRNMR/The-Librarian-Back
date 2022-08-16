
package com.thelibrarian.core.controller;

import com.lowagie.text.DocumentException;
import com.thelibrarian.data.dto.BookDto;
import com.thelibrarian.data.entity.BookEntity;
import com.thelibrarian.data.service.BookServiceBBDD;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

    @RestController
    public class BookControllerBBDD {

        @Autowired
        BookServiceBBDD bookService;

        @Autowired
        ModelMapper modelMapper;

        @GetMapping("/getAllBooks")
        public List<BookDto> findAll() {

            return bookService.findAll()
                    .stream()
                    .map(bookEntity -> modelMapper.map(bookEntity,BookDto.class))
                    .collect(Collectors.toList());

        }


        @PostMapping("/createBook")
        @ResponseStatus(code = HttpStatus.CREATED)
        public ResponseEntity <BookDto> save (@RequestBody BookDto bookDto) {

        return bookService.save(bookDto);

        }


        @DeleteMapping("/deleteBook/{id}")
        public ResponseEntity <ApiResponse> delete(@PathVariable Integer id) {

            bookService.delete(id);

            ApiResponse apiResponse = new ApiResponse();

            return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);

        }

        @PutMapping("/updateBook/{id}")
        public ResponseEntity<BookDto> Update(@RequestBody BookDto bookDto, @PathVariable Integer id) {

            BookEntity bookrequest = modelMapper.map(bookDto,BookEntity.class);

            BookEntity book = bookService.Update(bookrequest,id);

            BookDto bookResponse = modelMapper.map(book,BookDto.class);

            return ResponseEntity.ok().body(bookResponse);

        }

        @GetMapping("/getByIdBook/{id}")
        public ResponseEntity <BookDto> findById(@PathVariable Integer id) {

            BookEntity book = bookService.findById(id);

            BookDto bookDto = modelMapper.map(book,BookDto.class);

            return ResponseEntity.ok().body(bookDto);
        }

        @GetMapping("/getByIsbn/{isbn}")
        public ResponseEntity <BookDto> findByIsbn(@PathVariable String isbn) {

            BookEntity book = bookService.findByIsbn(isbn);

            BookDto bookDto = modelMapper.map(book,BookDto.class);

            return ResponseEntity.ok().body(bookDto);

        }

    }

