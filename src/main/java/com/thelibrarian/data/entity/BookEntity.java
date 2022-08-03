package com.thelibrarian.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_book;

    private String title;
    private Date publishedDate;
    private String isbn;
    private String description;
    private String imageLinks;
    private int pageCount;
    private String language;

    private int author;
    private int booksOfUser;
    private Long id_category;

    @JsonBackReference
    @OneToMany(targetEntity = AuthorEntity.class,mappedBy="id", fetch = FetchType.LAZY)
    private List<AuthorEntity> authors;

    @ManyToOne
    @JoinColumn(name="id_category", insertable = false,updatable = false)
    private CategoryEntity category;


    @JsonBackReference
    @OneToMany(targetEntity = BooksOfUserEntity.class,mappedBy="id", fetch = FetchType.LAZY)
    private List<BooksOfUserEntity> booksOfUsers;


}
