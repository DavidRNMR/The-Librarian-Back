package com.thelibrarian.integration.service;

import com.thelibrarian.integration.dto.BookDataDto;

public interface BookService {

    public BookDataDto getBook();
    public BookDataDto getBookByIsbn(String isbn);
}
