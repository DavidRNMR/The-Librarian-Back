package com.thelibrarian.integration.service;

import com.thelibrarian.integration.dto.BookDataDto;

public interface BookService {
    public BookDataDto getBook();
    public BookDataDto searchBookByTitleAuthor(String title, String author);
    public BookDataDto getBookByIsbn(String isbn);
    public BookDataDto getBookByAuthor(String author);
}
