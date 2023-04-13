package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Services.Interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author)
    {
        return authorService.addAuthor(author);
    }
    //delete  author by id
    //update author by Id
    //find a author by Id
    //find all authors
}
