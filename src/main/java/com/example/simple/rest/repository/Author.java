package com.example.simple.rest.repository;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Author implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Book> books;
}
