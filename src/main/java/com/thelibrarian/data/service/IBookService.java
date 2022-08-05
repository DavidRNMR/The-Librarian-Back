package com.thelibrarian.data.service;

import com.thelibrarian.data.entity.BookEntity;
import com.thelibrarian.data.entity.UsersEntity;

import java.util.List;

public interface IBookService {


    public BookEntity findByIsbn(String isbn);


}
