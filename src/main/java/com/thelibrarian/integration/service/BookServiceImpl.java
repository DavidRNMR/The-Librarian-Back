package com.thelibrarian.integration.service;

import com.thelibrarian.integration.dto.BookDataDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookServiceImpl implements BookService {

    RestTemplate restTemplate = new RestTemplate();


    String url = "https://www.googleapis.com/books/v1/volumes?q=";

    final String APIKEY = "&key=AIzaSyD6yt9yJuDcLr8ZVAPLiKGWoBzWgQtJHN4&maxResults<=11";

    @Override
    public ResponseEntity<BookDataDto> getBook() {

        String urlGetBook = url + "a" + APIKEY;

        BookDataDto bookDataDto = restTemplate.getForObject(urlGetBook, BookDataDto.class);

        if (bookDataDto == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(bookDataDto);

    }

    @Override
    public ResponseEntity<BookDataDto> searchBookByTitleAuthor(String title, String author) {

        String urlTitleAuthor = url + "+inauthor:" + author + "+intitle:" + title + APIKEY;

        BookDataDto bookDataDto = restTemplate.getForObject(urlTitleAuthor, BookDataDto.class);

        if (bookDataDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(bookDataDto);
    }

    @Override
    public ResponseEntity<BookDataDto> getBookByIsbn(String isbn) {

      String urlIsbn = url + "isbn:" + isbn + APIKEY;

        BookDataDto bookDataDtoIsbn = restTemplate.getForObject(urlIsbn, BookDataDto.class);

        if (bookDataDtoIsbn == null) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok().body(bookDataDtoIsbn);

    }

    @Override
    public ResponseEntity<BookDataDto> getBookByAuthor(String Author) {

        String urlAuthor = url + "+inauthor:" + Author + APIKEY;

      //  BookDataDto bookDataDto = new BookDataDto();

       BookDataDto bookDataDto = restTemplate.getForObject(urlAuthor, BookDataDto.class);

       

        if (bookDataDto == null) {

            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<BookDataDto>(bookDataDto, HttpStatus.OK);
    }

}
