package com.example.simple.rest.repository;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String autor;

    public Book(String title, String autor) {
        this.title = title;
        this.autor = autor;
    }
}
