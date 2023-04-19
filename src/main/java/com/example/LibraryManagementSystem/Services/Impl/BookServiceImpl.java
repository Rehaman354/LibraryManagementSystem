package com.example.LibraryManagementSystem.Services.Impl;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Entities.Book;
import com.example.LibraryManagementSystem.Repositories.AuthorRepository;
import com.example.LibraryManagementSystem.Repositories.BookRepository;
import com.example.LibraryManagementSystem.Services.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;



public class BookServiceImpl implements BookService {

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(Book book) throws Exception {
        try {
            int id = book.getAuthor().getId();
            Author author = authorRepository.findById(id).get();
            author.getBooks().add(book);
            book.setAuthor(author);//adding updated author to book entity
            authorRepository.save(author);//saving author ,no need to save book
        }catch (Exception e)
        {
            throw new Exception("Author does not exist,pls add author first then book");
        }
        return "Book added Successfully";
    }
}
