package com.thelibrarian.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="BOOKSAUTHORS")
@NoArgsConstructor
@AllArgsConstructor
public class BooksAuthors {

    private Long id_book;

    private Long id_author;
}
