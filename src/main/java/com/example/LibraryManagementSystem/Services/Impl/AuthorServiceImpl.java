package com.example.LibraryManagementSystem.Services.Impl;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Entities.Book;
import com.example.LibraryManagementSystem.Repositories.AuthorRepository;
import com.example.LibraryManagementSystem.RequestDtos.AuthorRequestDto;
import com.example.LibraryManagementSystem.RequestDtos.UpdateMobileByIdRequestDTo;
import com.example.LibraryManagementSystem.ResponseDtos.AuthorByEmailResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.AuthorResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.UpdateMobileByIdResponseDto;
import com.example.LibraryManagementSystem.Services.Interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(AuthorRequestDto authorDto) throws Exception
    {
        try {
             Author author = new Author();
            author.setAge(authorDto.getAge());
            author.setName(authorDto.getName());
            author.setEmail(authorDto.getEmail());
            author.setRating(authorDto.getRating());
            author.setMobileNo(authorDto.getMobileNo());
            authorRepository.save(author);
        }
        catch(Exception e)
        {
            throw new Exception(" pls check the details format");
        }

       return "Author added successfully";
    }

    @Override
    public AuthorByEmailResponseDto getAuthorByEmail(String email)  throws Exception{
        try {
            Author author = authorRepository.findByEmail(email);
            AuthorByEmailResponseDto response=new AuthorByEmailResponseDto();
            response.setId(author.getId());
            response.setName(author.getName());
            response.setAge(author.getAge());
            response.setBooks(author.getBooks());
            response.setRating(author.getRating());
            response.setMobileNo(author.getMobileNo());
            return response;
        }catch(Exception e)
        {
            throw new Exception("Email does not Exist");
        }
    }

    @Override
    public String deleteAuthor(int id) throws Exception {
        if(!authorRepository.existsById(id))
        {
            throw new Exception("Author Id not found!");
        }
        authorRepository.deleteById(id);//author books will be deleted automaticaly
        return "Author "+authorRepository.findById(id).get().getName()+ " deleted Successfully!";
    }

    @Override
    public UpdateMobileByIdResponseDto updateMobileOfAuthor(UpdateMobileByIdRequestDTo updateMobileByIdRequestDTo) throws Exception {
        int id=updateMobileByIdRequestDTo.getId();
        if(!authorRepository.existsById(id))
        {
            throw new Exception("Author does not exist");
        }
        authorRepository.findById(id).get().setMobileNo(updateMobileByIdRequestDTo.getNewMobileNo());
        UpdateMobileByIdResponseDto responseDto=new UpdateMobileByIdResponseDto();
        responseDto.setUpdatedMobile(authorRepository.findById(id).get().getMobileNo());
        responseDto.setName(authorRepository.findById(id).get().getName());
        return responseDto;
    }

    @Override
    public AuthorResponseDto getById(int id) throws Exception {
        Author author;
        try {
            author=authorRepository.findById(id).get();
        }catch(Exception e)
        {
            throw new Exception("Author Not found!");
        }
        AuthorResponseDto responseDto=new AuthorResponseDto();
        responseDto.setAge(author.getAge());
        responseDto.setName(author.getName());
        responseDto.setRating(author.getRating());
        responseDto.setEmail(author.getEmail());
        responseDto.setMobileNo(author.getMobileNo());
        List<String> books=new ArrayList<>();
        for(Book book: author.getBooks())
        {
           books.add(book.getTitle());
        }
        responseDto.setBooks(books);
        return responseDto;
    }

    @Override
    public List<AuthorResponseDto> getAllAuthors() throws Exception{
        List<AuthorResponseDto> authors=new ArrayList<>();
      for(Author author:  authorRepository.findAll())
      {
          int id= author.getId();
          authors.add(getById(id));
      }
      return authors;
    }


}
