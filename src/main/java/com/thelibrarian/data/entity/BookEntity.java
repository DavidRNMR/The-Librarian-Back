package com.thelibrarian.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="BOOKS")
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private Date publishedDate;
    private String isbn;
    private String description;
    private String imageLinks;
    private int pageCount;
    private String language;


    @OneToMany
    @JoinColumn(name = "id")
    private List<AuthorEntity> author;


    @OneToMany
    @JoinColumn(name = "id")
    private List<BookEntity> category;


    @OneToOne
    @JoinColumn(name = "id")
    private BooksOfUserEntity booksOfUser;


}
