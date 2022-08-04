package com.thelibrarian.integration.service;

import org.springframework.http.ResponseEntity;

import com.thelibrarian.integration.dto.BookDataDto;

public interface BookService {
    public ResponseEntity<BookDataDto> getRandomBooks();
    public ResponseEntity<BookDataDto> searchBookByTitleAuthor(String title, String author);
    public ResponseEntity<BookDataDto> getBookByIsbn(String isbn);
    public ResponseEntity<BookDataDto> getBookByAuthor(String author);
}
