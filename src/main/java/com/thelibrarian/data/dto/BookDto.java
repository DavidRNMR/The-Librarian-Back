package com.thelibrarian.data.dto;

import java.io.Serializable;
import java.util.Date;

public class BookDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id_book;

    private String title;
    private Date publishedDate;
    private String isbn;
    private String description;
    private String imageLinks;
    private int pageCount;
    private String language;
}
