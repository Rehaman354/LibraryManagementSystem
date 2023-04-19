package com.example.LibraryManagementSystem.Entities;

import com.example.LibraryManagementSystem.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//it will get automatically generated

    //user has to give these below 5 parameters to add a new book
    private String title;
    private int numberOfPages;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String publishedBy;
    private int price;
    private boolean issued=false;//

    @ManyToOne
    @JoinColumn
    private Author author;

    @ManyToOne
    @JoinColumn
    private Card card;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transaction> transactions=new ArrayList<>();


}
