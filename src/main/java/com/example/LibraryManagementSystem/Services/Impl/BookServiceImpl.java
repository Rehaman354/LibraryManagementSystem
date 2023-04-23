package com.example.LibraryManagementSystem.Services.Impl;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Entities.Book;
import com.example.LibraryManagementSystem.Repositories.AuthorRepository;
import com.example.LibraryManagementSystem.Repositories.BookRepository;
import com.example.LibraryManagementSystem.ResponseDtos.BookResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.DeleteBookResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.UpdatePriceResponseDto;
import com.example.LibraryManagementSystem.Services.Interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

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

    @Override
    public int noOfBooksOfAuthor(int id) throws Exception {
        Author author;
        int noOfBooks=0;
        try{
            author=authorRepository.findById(id).get();
            noOfBooks=author.getBooks().size();

        }catch(Exception e)
        {
            throw new Exception("Author not found!");
        }

        return noOfBooks;
    }

    @Override
    public DeleteBookResponseDto deleteBook(int id) throws Exception {
        Book book;
        try {
            book = bookRepository.findById(id).get();
        }catch(Exception e)
        {
            throw new Exception("Book not found");
        }
        if(book.isIssued())
        {
            throw new Exception("Book can't be deleted as it is not in library,it is isssued");
        }
        bookRepository.findById(id).get().getAuthor().getBooks().remove(book);
        bookRepository.deleteById(id);

        DeleteBookResponseDto responseDto=new DeleteBookResponseDto();
        responseDto.setBookTitle(book.getTitle());
        responseDto.setAuthorName(book.getAuthor().getName());
        return responseDto;
    }

    @Override
    public UpdatePriceResponseDto updatePriceById(int id,int newPrice) throws Exception {
        Book book;
        try {
            book = bookRepository.findById(id).get();
        }catch(Exception e)
        {
            throw new Exception("Book not found");
        }
        int oldPrice=book.getPrice();
        book.setPrice(newPrice);
        bookRepository.save(book);
        UpdatePriceResponseDto responseDto=new UpdatePriceResponseDto();
        responseDto.setBookTitle(book.getTitle());
        responseDto.setUpdatedPrice(newPrice);
        responseDto.setOldprice(oldPrice);
        return responseDto;
    }

    @Override
    public BookResponseDto getBookById(int id) throws Exception {
        Book book;
        try {
            book = bookRepository.findById(id).get();
        }catch(Exception e)
        {
            throw new Exception("Book not found");
        }
        BookResponseDto responseDto=new BookResponseDto();
        responseDto.setAuthorName(book.getAuthor().getName());
        responseDto.setPrice(book.getPrice());
        responseDto.setIssued(book.isIssued());
        responseDto.setGenre(book.getGenre());
        responseDto.setTitle(book.getTitle());
        responseDto.setNumberOfPages(book.getNumberOfPages());
        responseDto.setPublishedBy(book.getPublishedBy());
        return responseDto;
    }

    @Override
    public List<BookResponseDto> getAllBooks() throws Exception {
        List<BookResponseDto> responseDtos=new ArrayList<>();
        for(Book book:bookRepository.findAll())
        {
            responseDtos.add(getBookById(book.getId()));
        }
        return responseDtos;
    }

    @Override
    public List<BookResponseDto> getBooksOfAuthor(int id) throws Exception {
        List<BookResponseDto> responseDtos=new ArrayList<>();
        Author author;
        try {
            author=authorRepository.findById(id).get();
        }catch(Exception e)
        {
            throw new Exception("Author does not exist");
        }
      for( Book book: author.getBooks())
      {
         responseDtos.add(getBookById(book.getId()));
      }
      return  responseDtos;
    }
}
