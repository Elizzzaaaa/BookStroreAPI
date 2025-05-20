package com.bookstore.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceInterface {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book createBook( Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        Book existingBook = getBookById(book.getId());
        if(existingBook!=null){
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            return bookRepository.save(existingBook);
        } else {
            return null;
        }
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book searchBook(String title){
        return bookRepository.findByTitle(title);

    }

}
