package com.thelibrarian.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="BOOK")
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private long idAuthor;
    private Date publishedDate;
    private String isbn;
    private String description;
    private String imageLinks;
    private int pageCount;
    private long idCategory;
    private String language;
}
