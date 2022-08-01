package com.thelibrarian.integration.service;

import com.thelibrarian.integration.dto.BookDataDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookServiceImpl implements BookService {

    RestTemplate restTemplate = new RestTemplate();
    String url = "https://www.googleapis.com/books/v1/volumes?q=sun&printType=books&maxResults=1";

    @Override
    public BookDataDto getBook() {
        BookDataDto bookDataDto = restTemplate.getForObject(url, BookDataDto.class);
        System.out.println(bookDataDto.items[0].volumeInfo.getTitle());
        return bookDataDto;
    }
}
