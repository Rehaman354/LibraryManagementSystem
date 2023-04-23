package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Entities.Book;
import com.example.LibraryManagementSystem.Services.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public String addBook(@RequestBody Book book) throws Exception {
        return bookService.addBook(book);
    }

    //find no of books of an author
    @GetMapping("/")
    //delete book by its id
    //update its price by id
    //find all the books
    //find all books of a particular author by author id
}
