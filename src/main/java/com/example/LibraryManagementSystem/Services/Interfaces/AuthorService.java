package com.example.LibraryManagementSystem.Services.Interfaces;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.RequestDtos.AuthorRequestDto;
import com.example.LibraryManagementSystem.RequestDtos.UpdateMobileByIdRequestDTo;
import com.example.LibraryManagementSystem.ResponseDtos.AuthorByEmailResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.AuthorResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.UpdateMobileByIdResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {
  String addAuthor(AuthorRequestDto author) throws Exception;
   AuthorByEmailResponseDto getAuthorByEmail(String email) throws Exception;

    String deleteAuthor(int id) throws Exception;

    UpdateMobileByIdResponseDto updateMobileOfAuthor(UpdateMobileByIdRequestDTo updateMobileByIdRequestDTo) throws Exception;

    AuthorResponseDto getById(int id) throws Exception;

    List<AuthorResponseDto> getAllAuthors() throws Exception;
}
