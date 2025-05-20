package com.bookstore.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById (@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
       return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/titles/{title}")
    public Book searchBook(@PathVariable String title) {
       return bookService.searchBook(title);
    }

    @GetMapping("/titles")
    public List<String> allTitles(){
        List<String> title = new ArrayList<>();
        List<Book> books = bookService.getAllBooks();
        for(Book book : books) {
            title.add(book.getTitle());
        }
        return title;
    }

}
