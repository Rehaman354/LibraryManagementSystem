package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Entities.Book;
import com.example.LibraryManagementSystem.Services.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public String addBook(@RequestBody Book book) throws Exception {
        return bookService.addBook(book);
    }
    //find all the books

    //find all books of a particular author by author id
    //find no of books of an author
}
