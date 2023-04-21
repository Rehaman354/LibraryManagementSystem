package com.example.LibraryManagementSystem.Services.Interfaces;

import com.example.LibraryManagementSystem.Entities.Book;
import org.springframework.stereotype.Service;


public interface BookService {
    String addBook(Book book) throws Exception;
}
