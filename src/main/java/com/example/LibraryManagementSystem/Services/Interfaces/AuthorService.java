package com.example.LibraryManagementSystem.Services.Interfaces;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.RequestDtos.AuthorRequestDto;
import com.example.LibraryManagementSystem.ResponseDtos.AuthorByEmailResponseDto;
import org.springframework.stereotype.Service;

public interface AuthorService {
  String addAuthor(AuthorRequestDto author) throws Exception;
   AuthorByEmailResponseDto getAuthorByEmail(String email) throws Exception;
}
