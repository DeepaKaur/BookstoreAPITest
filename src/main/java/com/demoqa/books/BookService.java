package com.demoqa.books;

import io.restassured.response.ValidatableResponse;


import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

public class BookService {
    final static String url = "https://demoqa.com/BookStore/v1/Books";

    public ValidatableResponse getResponse(String url) {
        return get(url).then();
    }

    public void validateBookWithISBN(ValidatableResponse response, String isbn) {
        response.body("books.isbn", hasItem("9781449331818"));
    }

    public void validateBookCount(ValidatableResponse response, int i) {

        response.body("books.isbn", hasSize(i));
       }

    public void validateBooksSchema(ValidatableResponse response) {

        response.assertThat().body(matchesJsonSchemaInClasspath("books-schema.json"));
    }
}