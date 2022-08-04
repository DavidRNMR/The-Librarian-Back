
package com.thelibrarian.data.repository;

import com.thelibrarian.data.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookDao extends JpaRepository<BookEntity,Long> {

}

