package com.question1.bookRental.Question1.controller;
import com.question1.bookRental.Question1.entity.Book;
import com.question1.bookRental.Question1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Search books by title or genre
    @GetMapping("/search")
    public ResponseEntity<?> searchBooks(@RequestParam String keyword) {
        return ResponseEntity.ok(bookService.searchBooks(keyword));
    }

    @PostMapping("/add")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    // Get available books
    @GetMapping("/available")
    public ResponseEntity<List<Book>> getAvailableBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // Get books by genres
    @GetMapping("/genres")
    public ResponseEntity<List<Book>> getBooksByGenres(@RequestParam List <String> genres) {
        return ResponseEntity.ok(bookService.getBooksByGenre(genres));
    }
}