package com.example.LibraryManagementSystem.Services.Impl;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Repositories.AuthorRepository;
import com.example.LibraryManagementSystem.Services.Interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author)
    {
        authorRepository.save(author);
       return "Author added successfully";
    }

}
