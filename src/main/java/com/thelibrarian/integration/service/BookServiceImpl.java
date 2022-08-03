package com.thelibrarian.integration.service;

import com.thelibrarian.integration.dto.BookDataDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookServiceImpl implements BookService {

    RestTemplate restTemplate = new RestTemplate();
    String url = "https://www.googleapis.com/books/v1/volumes?printType=books&q=";

    @Override
    public ResponseEntity<BookDataDto> getBook() {

        url += "a";

        BookDataDto bookDataDto = restTemplate.getForObject(url, BookDataDto.class);

        if (bookDataDto == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(bookDataDto);
       
    }
@Override
    public ResponseEntity<BookDataDto> searchBookByTitleAuthor(String title, String author) {

        url += "+inauthor:" + author + "+intitle:" + title;

        BookDataDto bookDataDto = restTemplate.getForObject(url, BookDataDto.class);
      

        if (bookDataDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(bookDataDto);
    }

    @Override
    public ResponseEntity <BookDataDto> getBookByIsbn(String isbn) {

        url+="isbn:"+isbn;

        BookDataDto bookDataDtoIsbn = restTemplate.getForObject(url, BookDataDto.class);

         if(bookDataDtoIsbn == null){

            return ResponseEntity.notFound().build();

        }else{

            return ResponseEntity.ok().body(bookDataDtoIsbn);

        }

       
    }

@Override
    public ResponseEntity<BookDataDto> getBookByAuthor(String Author){

         url += "+inauthor:" + Author;

        BookDataDto bookDataDto = restTemplate.getForObject(url, BookDataDto.class);



        if (bookDataDto == null) {

            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(bookDataDto);
        }
    }


}
