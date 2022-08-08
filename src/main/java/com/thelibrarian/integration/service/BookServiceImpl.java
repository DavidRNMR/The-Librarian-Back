package com.thelibrarian.integration.service;

import com.thelibrarian.integration.dto.BookDataDto;

import com.thelibrarian.integration.dto.BookDto;
import com.thelibrarian.integration.utilities.Utilities;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    final String APIKEY = "&key=AIzaSyD6yt9yJuDcLr8ZVAPLiKGWoBzWgQtJHN4&maxResults=36";
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://www.googleapis.com/books/v1/volumes?q=";

    @Override
    public ResponseEntity<BookDataDto> getRandomBooks() {

        String urlGetBook = url + Utilities.generateRandomLetter() + APIKEY;

        BookDataDto bookDataDto = restTemplate.getForObject(urlGetBook, BookDataDto.class);

        if (bookDataDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(checkCorrectDataInsert(bookDataDto));

    }

    @Override
    public ResponseEntity<BookDataDto> searchBookByTitleAuthor(String title, String author) {

        String urlTitleAuthor = url + "+inauthor:" + author + "+intitle:" + title + APIKEY;

        BookDataDto bookDataDto = restTemplate.getForObject(urlTitleAuthor, BookDataDto.class);

        if (bookDataDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(checkCorrectDataInsert(bookDataDto));
    }

    @Override
    public ResponseEntity<BookDataDto> getBookByIsbn(String isbn) {

        String urlIsbn = url + "isbn:" + isbn + APIKEY;

        BookDataDto bookDataDtoIsbn = restTemplate.getForObject(urlIsbn, BookDataDto.class);

        if (bookDataDtoIsbn == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(checkCorrectDataInsert(bookDataDtoIsbn));

    }

    @Override
    public ResponseEntity<BookDataDto> getBookByAuthor(String Author) {

        String urlAuthor = url + "+inauthor:" + Author + APIKEY;

        BookDataDto bookDataDto = restTemplate.getForObject(urlAuthor, BookDataDto.class);

        if (bookDataDto == null) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(checkCorrectDataInsert(bookDataDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookDataDto> getBookByTitle(String title) {

        String urlTitle = url + "+intitle:" + title + APIKEY;

        BookDataDto bookDataDto = restTemplate.getForObject(urlTitle, BookDataDto.class);

        if (bookDataDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(checkCorrectDataInsert(bookDataDto));
    }

    private BookDataDto checkCorrectDataInsert(BookDataDto bookDataDto) {

        for (int i = 0; i < bookDataDto.getItems().length; i++) {

            if (bookDataDto.getItems()[i].getVolumeInfo().getTitle() == null) {
                bookDataDto.getItems()[i].getVolumeInfo().setTitle("No title available.");
            }

            if (bookDataDto.getItems()[i].getVolumeInfo().getAuthors() == null) {
                String[] authors = {"No authors info available."};
                bookDataDto.getItems()[i].getVolumeInfo().setAuthors(authors);
            }

            if (bookDataDto.getItems()[i].getVolumeInfo().getPublishedDate() == null) {
                bookDataDto.getItems()[i].getVolumeInfo().setPublishedDate("No published date available.");
            }

            if (bookDataDto.getItems()[i].getVolumeInfo().getDescription() == null) {
                bookDataDto.getItems()[i].getVolumeInfo().setDescription("No description available.");
            }

            if (bookDataDto.getItems()[i].getVolumeInfo().getImageLinks() == null) {
                Map<String, String> imageLinks = new HashMap<>();
                imageLinks.put("smallThumbnail", "No image available.");
                bookDataDto.getItems()[i].getVolumeInfo().setImageLinks(imageLinks);
            }

            if (bookDataDto.getItems()[i].getVolumeInfo().getCategories() == null) {
                String[] categories = {"No categories specified."};
                bookDataDto.getItems()[i].getVolumeInfo().setCategories(categories);
            }

            if (bookDataDto.getItems()[i].getVolumeInfo().getLanguage() == null) {
                bookDataDto.getItems()[i].getVolumeInfo().setLanguage("Language not specified");
            }

            if (bookDataDto.getItems()[i].getVolumeInfo().getIndustryIdentifiers() == null || bookDataDto.getItems()[i].getVolumeInfo().getIndustryIdentifiers().length == 1) {
                Map<String, String> isbn = new HashMap<>();
                isbn.put("identifier", "No isbn available.");
                Map<String, String>[] industryIdentifiers = new HashMap[1];
                industryIdentifiers[0] = isbn;
                bookDataDto.getItems()[i].getVolumeInfo().setIndustryIdentifiers(industryIdentifiers);
            } else {
                for (Map<String, String> isbn : bookDataDto.getItems()[i].getVolumeInfo().getIndustryIdentifiers()) {

                    if (isbn.get("type").equals("ISBN_13")) {
                        Map<String, String> newIsbn = new HashMap<>();
                        newIsbn.put("identifier", isbn.get("identifier"));
                        Map<String, String>[] industryIdentifiers = new HashMap[1];
                        industryIdentifiers[0] = newIsbn;
                        bookDataDto.getItems()[i].getVolumeInfo().setIndustryIdentifiers(industryIdentifiers);

                        break;
                    }
                }

            }
        }

        return bookDataDto;
    }

    private BookDataDto checkAuthorExistence(BookDataDto bookDataDto) {

        List<BookDto> booksList = new ArrayList<>();

        for (int i = 0; i < bookDataDto.getItems().length; i++) {
            if (bookDataDto.getItems()[i].getVolumeInfo().getAuthors() != null) {
                booksList.add(bookDataDto.getItems()[i]);
            }
        }

        BookDto[] booksArray = new BookDto[booksList.size()];
        booksList.toArray(booksArray);
        bookDataDto.setItems(booksList.toArray(booksArray));

        return bookDataDto;
    }

}
