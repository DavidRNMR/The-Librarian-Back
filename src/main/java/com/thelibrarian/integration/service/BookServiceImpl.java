package com.thelibrarian.integration.service;

import com.thelibrarian.integration.dto.BookDataDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookServiceImpl implements BookService {

    RestTemplate restTemplate = new RestTemplate();
    String url = "https://www.googleapis.com/books/v1/volumes?printType=books&q=";

    @Override
    public BookDataDto getBook() {

        BookDataDto bookDataDto = restTemplate.getForObject(url, BookDataDto.class);
    
        
        return bookDataDto;
    }

    @Override
    public BookDataDto getBookByIsbn(String isbn) {
        
        url+="isbn:"+isbn;
        BookDataDto bookDataDtoIsbn = restTemplate.getForObject(url, BookDataDto.class);
      
    

        return bookDataDtoIsbn;
    }



}
