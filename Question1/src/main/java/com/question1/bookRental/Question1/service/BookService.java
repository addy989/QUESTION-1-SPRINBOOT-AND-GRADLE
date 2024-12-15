package com.question1.bookRental.Question1.service;

import com.question1.bookRental.Question1.entity.Book;
import com.question1.bookRental.Question1.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }



    public List<Book> getBooksByGenre(List<String> genre) {
        return bookRepository.findByGenre(genre);
    }

    // Search books based on a query
    public List<Book> searchBooks(String query) {
        return bookRepository.searchBooks(query);
    }

    // Add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Remove a book
    public void removeBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Check if the book exists
    public boolean bookExists(Long id) {
        return bookRepository.existsById(id);
    }
}
