package com.thelibrarian.data.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
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
    private Long id;

    private String title;
    private Date publishedDate;
    private String isbn;
    private String description;
    private String imageLinks;
    private Integer pageCount;
    private String language;


   /* @OneToMany
    private List<AuthorEntity> authors;

    @OneToMany
    private List<CategoryEntity> categories;*/


    // @OneToOne
    // private List<BooksOfUserEntity> booksOfUsers;


}

