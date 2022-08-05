
package com.thelibrarian.data.repository;

import com.thelibrarian.data.entity.BookEntity;
import com.thelibrarian.data.service.BookServiceBBDD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookDao extends JpaRepository<BookEntity,Integer> {
    public BookEntity findByIsbn(String isbn);

}

