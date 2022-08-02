package com.thelibrarian.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="Books")
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private long idAuthor;
    private Date publishedDate;
    private String isbn;
    private String description;
    private String imageLinks;
    private int pageCount;
    private long idCategory;
    private String language;

    @OneToOne
    @JoinColumn(name = "id")
    private BooksOfUserEntity booksOfUser;


}
