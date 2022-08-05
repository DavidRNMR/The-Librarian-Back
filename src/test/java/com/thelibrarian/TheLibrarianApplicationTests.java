package com.thelibrarian;

import com.thelibrarian.integration.dto.BookDataDto;
import com.thelibrarian.integration.dto.BookDto;
import com.thelibrarian.integration.service.BookServiceImpl;
import com.thelibrarian.integration.utilities.AuthorsForTest;
import com.thelibrarian.integration.utilities.TitlesForTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TheLibrarianApplicationTests {

    private static BookDataDto randomBooks;
    private static BookDto[] booksArray;
    private static BookServiceImpl bookService;

    @BeforeAll
    public static void setUp() {
        bookService = new BookServiceImpl();
        randomBooks = bookService.getRandomBooks().getBody();
    }

    @Test
    @DisplayName("Test size of random books list")
    public void getBooksCount() {
        Assertions.assertEquals(36, randomBooks.items.length);
    }

    @Test()
    @DisplayName("Test book language")
    public void getException() {
        Exception exception = Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt(randomBooks.items[0].volumeInfo.getLanguage());
        });

        String expectedMessage = "For input string: \"" + randomBooks.items[0].volumeInfo.getLanguage() + "\"";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Test book by author")
    public void getBookByAuthor() {

        String authorActualName;

        for (AuthorsForTest author : AuthorsForTest.values()) {

            booksArray = bookService.getBookByAuthor(author.name()).getBody().getItems();

            for (BookDto book : booksArray) {
                if (book.getVolumeInfo().getAuthors() != null) {
                    for (int i = 0; i < book.getVolumeInfo().getAuthors().length; i++) {
                        if (book.getVolumeInfo().getAuthors()[i].contains(author.name())) {
                            authorActualName = book.getVolumeInfo().getAuthors()[i];
                            Assertions.assertEquals(authorActualName, book.getVolumeInfo().getAuthors()[i]);
                        }

                    }

                }

            }

        }
    }

    @Test
    @DisplayName("Test book by title")
    public void getBookByTitle() {

        String actualTitle;

        for (TitlesForTest title : TitlesForTest.values()) {
            booksArray = bookService.getBookByTitle(title.name()).getBody().getItems();

            for (BookDto book : booksArray) {
                if (book.getVolumeInfo().getTitle().contains(title.name())) {
                    actualTitle = book.getVolumeInfo().getTitle();
                    Assertions.assertEquals(actualTitle, book.getVolumeInfo().getTitle());
                }

            }
        }
    }

    @Test
    @DisplayName("Test book by isbn")
    public void getBookByIsbn() {
        booksArray = bookService.getBookByIsbn("9780738702865").getBody().getItems();
        Assertions.assertEquals(booksArray[0].getVolumeInfo().getIndustryIdentifiers()[1].get("identifier"), "9780738702865");
    }

}
