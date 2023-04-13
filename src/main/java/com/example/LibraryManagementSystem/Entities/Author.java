package com.example.LibraryManagementSystem.Entities;

import com.example.LibraryManagementSystem.Enums.Department;
import com.example.LibraryManagementSystem.Enums.StudentYear;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="author")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//it will get automatically generated

    //user has to give these below 5 parameters to add a new author
    private String name;
    private int age;
    private String mobileNo;
    private String email;
    private int rating; //

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)//parent to child mapping
    private List<Book> books=new ArrayList<>();
    //initially allocating empty book list for author
}
