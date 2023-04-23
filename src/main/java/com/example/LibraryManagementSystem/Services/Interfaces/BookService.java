package com.example.LibraryManagementSystem.Services.Interfaces;

import com.example.LibraryManagementSystem.Entities.Book;
import com.example.LibraryManagementSystem.ResponseDtos.BookResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.DeleteBookResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.UpdatePriceResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    String addBook(Book book) throws Exception;

    int noOfBooksOfAuthor(int id) throws Exception;

    DeleteBookResponseDto deleteBook(int id) throws Exception;

    UpdatePriceResponseDto updatePriceById(int id,int newPrice) throws Exception;

    BookResponseDto getBookById(int id) throws Exception;

    List<BookResponseDto> getAllBooks() throws Exception;

    List<BookResponseDto> getBooksOfAuthor(int id) throws Exception;
}
