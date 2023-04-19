package com.example.LibraryManagementSystem.Services.Interfaces;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.ResponseDtos.AuthorByEmailResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
  String addAuthor(Author author);
   AuthorByEmailResponseDto getAuthorByEmail(String email) throws Exception;
}
