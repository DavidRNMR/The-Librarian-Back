package com.thelibrarian.data.repository;

import com.thelibrarian.data.entity.AuthorEntity;
import com.thelibrarian.data.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorDao extends JpaRepository<AuthorEntity,Long> {

}
