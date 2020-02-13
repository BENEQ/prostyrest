package com.example.simple.rest.repository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    Book addBook(@RequestBody Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @GetMapping("/books/{id}")
    Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).get();
    }

    @PutMapping("/book/{id}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {

        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setAutors(newBook.getAutors());
                    book.setCena(newBook.getCena());
                    book.setLiczbaStron(newBook.getLiczbaStron());
                    book.setRokWydania(newBook.getRokWydania());
                    return bookRepository.save(book);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return bookRepository.save(newBook);
                });
    }

    @DeleteMapping("/books/{id}")
    void deleteBooks(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
