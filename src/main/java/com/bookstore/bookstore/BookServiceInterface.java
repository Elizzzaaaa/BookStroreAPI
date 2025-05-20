package com.bookstore.bookstore;

import java.util.List;

public interface BookServiceInterface {

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book createBook(Book book);

    Book updateBook(Book book);

    void deleteBook(Long id);

    Book searchBook(String title);
}
