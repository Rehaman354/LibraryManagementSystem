package com.example.LibraryManagementSystem.ResponseDtos;

import com.example.LibraryManagementSystem.Entities.Book;
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
public class AuthorByEmailResponseDto {
    private int id;

    private String name;
    private int age;
    private String mobileNo;
    private int rating;

    private List<Book> books=new ArrayList<>();
}
