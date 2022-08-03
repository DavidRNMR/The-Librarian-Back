package com.thelibrarian.data.service;

import com.thelibrarian.data.entity.BookEntity;
import com.thelibrarian.data.repository.IBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceBBDD  {

    @Autowired
    IBookDao bookDao;


    public List<BookEntity> findAll() {

        return bookDao.findAll();
    }

    public void save(BookEntity book) {

        bookDao.save(book);
    }

    public BookEntity findOne(Long id) {

        return bookDao.findById(id).orElse(null);
    }

    public void delete(Long id) {

        bookDao.deleteById(id);

    }
    public BookEntity Update (BookEntity book, Long id){

        if(bookDao.existsById(id)){

            book.setId_book(id);

            return bookDao.save(book);
        }
        return null;
    }

    public BookEntity findByTitleAndAuthor(String title, String nameAuthor){

        return bookDao.findByTitleAndAuthor(title, nameAuthor);

    }

    public BookEntity findByAuthor(String nameAuthor){

        return bookDao.findByAuthor(nameAuthor);
    }


    public BookEntity findByIsbn(String isbn){

       return bookDao.findByIsbn(isbn);
    }

}
