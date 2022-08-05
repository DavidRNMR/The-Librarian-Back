package com.thelibrarian;

import com.thelibrarian.integration.dto.BookDataDto;
import com.thelibrarian.integration.dto.BookDto;
import com.thelibrarian.integration.service.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class TheLibrarianApplicationTests {

	private static BookDataDto randomBooks;
	private static BookDto[] booksByAuthor;
	private static BookServiceImpl bookService;
	private static String author;

	@BeforeAll
	public static void setUp() {
		bookService = new BookServiceImpl();
		randomBooks = bookService.getRandomBooks().getBody();
		author = "King";
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
	public void GetBookByAuthor() {
		booksByAuthor = bookService.getBookByAuthor(author).getBody().getItems();
		String authorActualName = "";

		for (BookDto book : booksByAuthor) {
			if (book.getVolumeInfo().getAuthors() != null) {
				for (int i = 0; i < book.getVolumeInfo().getAuthors().length; i++) {
					if (book.getVolumeInfo().getAuthors()[i].contains(author)) {
						authorActualName = book.getVolumeInfo().getAuthors()[i];
					}
					Assertions.assertEquals(authorActualName, book.getVolumeInfo().getAuthors()[1]);
				}
			}
		}
	}

}
