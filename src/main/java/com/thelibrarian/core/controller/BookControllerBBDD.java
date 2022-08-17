
package com.thelibrarian.core.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thelibrarian.data.dto.BookDto;
import com.thelibrarian.data.entity.BookEntity;
import com.thelibrarian.data.service.BookServiceBBDD;

import io.swagger.v3.oas.models.responses.ApiResponse;

    @RestController
    public class BookControllerBBDD {

        @Autowired
        BookServiceBBDD bookService;

        @Autowired
        ModelMapper modelMapper;

        @GetMapping("/getAllBooks")
        public List<BookDto> findAll() {

            return bookService.findAll();

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
        public ResponseEntity<BookDto> Update(@PathVariable Integer id,@RequestBody BookDto bookDto) {

            BookEntity bookRequest = modelMapper.map(bookDto,BookEntity.class);

            BookEntity book = bookService.Update(bookRequest,id);

            BookDto bookResponse = modelMapper.map(book,BookDto.class);

            return ResponseEntity.ok().body(bookResponse);

        }

        @GetMapping("/getByIdBook/{id}")
        public  BookDto findById(@PathVariable Integer id) {

            /*BookEntity book = bookService.findById(id);

            BookDto bookDto = modelMapper.map(book,BookDto.class);

            return ResponseEntity.ok().body(bookDto);*/

            return convertToDto(bookService.findById(id));
        }

        @GetMapping("/getByIsbn/{isbn}")
        public ResponseEntity <BookDto> findByIsbn(@PathVariable String isbn) {

            BookEntity book = bookService.findByIsbn(isbn);

            BookDto bookDto = modelMapper.map(book,BookDto.class);

            return ResponseEntity.ok().body(bookDto);

        }

        private BookDto convertToDto(BookEntity book) {
            BookDto bookDto = modelMapper.map(book, BookDto.class);
            return bookDto;
        }
    }

