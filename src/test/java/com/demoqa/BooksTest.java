package com.demoqa;
import com.demoqa.books.BookService;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class BooksTest {
    BookService bookService = new BookService();
    private static final String url = "https://demoqa.com/BookStore/v1/Books";

    @Test
    public void validateIsbnPresent() {
        ValidatableResponse response = bookService.getResponse(url);
        bookService.validateBookWithISBN(response, "9781449331818");
    }

    @Test
    public void validateNumberOfBookCount() {
        ValidatableResponse response = bookService.getResponse(url);
        bookService.validateBookCount(response, 8);
    }

    @Test
    public void validateBooksJsonSchema() {
        ValidatableResponse response = bookService.getResponse(url);
        bookService.validateBooksSchema(response);
      }


}
