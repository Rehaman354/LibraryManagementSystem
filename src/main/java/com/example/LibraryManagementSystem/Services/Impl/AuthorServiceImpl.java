package com.example.LibraryManagementSystem.Services.Impl;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Repositories.AuthorRepository;
import com.example.LibraryManagementSystem.ResponseDtos.AuthorByEmailResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.GetStudentResponseDto;
import com.example.LibraryManagementSystem.Services.Interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author)
    {
        authorRepository.save(author);
       return "Author added successfully";
    }

    @Override
    public AuthorByEmailResponseDto getAuthorByEmail(String email)  throws Exception{
        try {
            Author author = authorRepository.findByEmail(email);
            AuthorByEmailResponseDto response=new AuthorByEmailResponseDto();
            response.setId(author.getId());
            response.setName(author.getName());
            response.setAge(author.getAge());
            response.setBooks(author.getBooks());
            response.setRating(author.getRating());
            response.setMobileNo(author.getMobileNo());
            return response;
        }catch(Exception e)
        {
            throw new Exception("Email does not Exist");
        }
    }

}
