package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.ResponseDtos.AuthorByEmailResponseDto;
import com.example.LibraryManagementSystem.Services.Interfaces.AuthorService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    //add an author
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author)
    {
        return authorService.addAuthor(author);
    }

    //find author By Email
    @GetMapping("/getByEmail")
    public AuthorByEmailResponseDto getAuthorByEmail(@RequestParam("email") String email) throws Exception
    {
        return authorService.getAuthorByEmail(email);
    }
    //delete  author by id
    //update author mobno by Id
    //find a author by Id
    //find all authors

}
