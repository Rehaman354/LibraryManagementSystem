package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Entities.Book;
import com.example.LibraryManagementSystem.ResponseDtos.BookResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.DeleteBookResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.UpdatePriceResponseDto;
import com.example.LibraryManagementSystem.Services.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    //adding book
    @PostMapping("/add")
    public String addBook(@RequestBody Book book) throws Exception {
        return bookService.addBook(book);
    }

    //find no of books of an author
    @GetMapping("/booksOfAuthor")
    public int noOfBooksOfAuthor(@RequestParam("id") int id) throws Exception
    {
        return bookService.noOfBooksOfAuthor(id);
    }
    //delete book by its id
    @DeleteMapping("/delete")
    public DeleteBookResponseDto deleteBook(@RequestParam("id") int id) throws Exception
    {
        return bookService.deleteBook(id);
    }
    //update its price by id
    @PutMapping("/updatePrice")
    public UpdatePriceResponseDto updatePriceById(@RequestParam("id") int id,@RequestParam ("newPrice") int newPrice) throws Exception
    {
        return bookService.updatePriceById(id,newPrice);
    }

    //find book by id
    @GetMapping("/getBookById")
    public BookResponseDto getBookById(@RequestParam("id") int id) throws Exception
    {
        return bookService.getBookById(id);
    }
    //find all the books
    @GetMapping("/getAllBooks")
    public List<BookResponseDto> getAllBooks() throws Exception{
        return bookService.getAllBooks();
    }
    //find all books of a particular author by author id
    @GetMapping("/getBooksOfAuthor")
    public List<BookResponseDto> getBooksOfAuthor(@RequestParam("id") int id) throws Exception{
        return bookService.getBooksOfAuthor(id);
    }
}
