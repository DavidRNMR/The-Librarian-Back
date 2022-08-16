
package com.thelibrarian.data.service;

import com.thelibrarian.data.dto.BookDto;
import com.thelibrarian.data.entity.BookEntity;
import com.thelibrarian.data.repository.IBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceBBDD implements IBookService {

    @Autowired
    private IBookDao bookDao;


    public List <BookEntity> findAll(){

        return bookDao.findAll();
    }


    public ResponseEntity <BookDto> save(BookDto bookDto) {

         BookEntity bookEntity = new BookEntity();

         bookEntity.setId_book(bookDto.getId_book());
         bookEntity.setTitle(bookDto.getTitle());
         bookEntity.setPublishedDate(bookDto.getPublishedDate());
         bookEntity.setIsbn(bookDto.getIsbn());
         bookEntity.setDescription(bookDto.getDescription());
         bookEntity.setImageLinks(bookDto.getImageLinks());
         bookEntity.setPageCount(bookDto.getPageCount());
         bookEntity.setPageCount(bookDto.getPageCount());

         return ResponseEntity.ok().body(bookDto);
    }

    public BookEntity findById(Integer id) {

        return bookDao.findById(id).orElse(null);
    }

    public void delete(Integer id) {

        bookDao.deleteById(id);

    }
    public BookEntity Update (BookEntity book, Integer id){

        if(bookDao.existsById(id)){

            book.setId_book(id);

            return bookDao.save(book);
        }
        return null;
    }

    @Override
    public BookEntity findByIsbn(String isbn) {

        return bookDao.findByIsbn(isbn);

    }
}


