package com.example.simple.rest.repository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping("/authors")
    Author addAuthor(@RequestBody Author author) {
        return authorRepository.saveAndFlush(author);
    }

    @GetMapping("/authors/{id}")
    Author getAuthorById(@PathVariable Long id) {
        return authorRepository.findById(id).get();
    }

    @PutMapping("/author/{id}")
    Author replaceBook(@RequestBody Author newAuthor, @PathVariable Long id) {

        return authorRepository.findById(id)
                .map(author -> {
                    author.setName(newAuthor.getName());
                    author.setSurname(newAuthor.getSurname());
                    return authorRepository.save(author);
                })
                .orElseGet(() -> {
                    newAuthor.setId(id);
                    return authorRepository.save(newAuthor);
                });
    }

    @DeleteMapping("/authors/{id}")
    void deleteBooks(@PathVariable Long id) {
        authorRepository.deleteById(id);
    }
}
