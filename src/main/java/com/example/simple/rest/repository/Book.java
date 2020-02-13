package com.example.simple.rest.repository;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Book implements Serializable {
    @Id
    @GeneratedValue()
    private Long id;
    private String title;
@JsonIgnore
    @ManyToMany(mappedBy = "books")
    private List<Author> autors;
    private Integer rokWydania;
    private Integer liczbaStron;
    private Double cena;

}
