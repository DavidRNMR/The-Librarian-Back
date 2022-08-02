package com.thelibrarian.integration.service;

import com.thelibrarian.integration.dto.BookDataDto;
import com.thelibrarian.integration.dto.BookDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookServiceImpl implements BookService {

    RestTemplate restTemplate = new RestTemplate();
    String url = "https://www.googleapis.com/books/v1/volumes?printType=books&q=";

    @Override
    public BookDataDto getBook() {
        url += "a";
        BookDataDto bookDataDto = restTemplate.getForObject(url, BookDataDto.class);
        return bookDataDto;
    }
@Override
    public BookDataDto searchBookByTitleAuthor(String title, String author) {
        url += "+inauthor:" + author + "+intitle:" + title;
        BookDataDto bookDataDto = restTemplate.getForObject(url, BookDataDto.class);
        return bookDataDto;
    }

    @Override
    public BookDataDto getBookByIsbn(String isbn) {

        url+="isbn:"+isbn;

        BookDataDto bookDataDtoIsbn = restTemplate.getForObject(url, BookDataDto.class);


        System.out.println(bookDataDtoIsbn.toString());

        return bookDataDtoIsbn;
    }

@Override
    public BookDataDto getBookByAuthor(String Author){
         url += "+inauthor:" + Author;
        BookDataDto bookDataDto = restTemplate.getForObject(url, BookDataDto.class);
        return bookDataDto;
    }


}
