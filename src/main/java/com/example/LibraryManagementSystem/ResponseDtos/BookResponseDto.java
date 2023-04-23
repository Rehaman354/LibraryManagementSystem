package com.example.LibraryManagementSystem.ResponseDtos;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Entities.Card;
import com.example.LibraryManagementSystem.Entities.Transaction;
import com.example.LibraryManagementSystem.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookResponseDto {


    private String title;
    private int numberOfPages;

    private Genre genre;
    private String publishedBy;
    private int price;
    private boolean issued;


    //book's authorname
    private String authorName;


}
