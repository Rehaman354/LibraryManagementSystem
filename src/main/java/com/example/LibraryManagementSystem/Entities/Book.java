package com.example.LibraryManagementSystem.Entities;

import com.example.LibraryManagementSystem.Enums.Department;
import com.example.LibraryManagementSystem.Enums.Genre;
import com.example.LibraryManagementSystem.Enums.StudentYear;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private int price;//

    @ManyToOne
    @JoinColumn
    private Author author;
}
