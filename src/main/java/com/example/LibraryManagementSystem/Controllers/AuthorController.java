package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.RequestDtos.AuthorRequestDto;
import com.example.LibraryManagementSystem.RequestDtos.UpdateMobileByIdRequestDTo;
import com.example.LibraryManagementSystem.ResponseDtos.AuthorByEmailResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.AuthorResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.UpdateMobileByIdResponseDto;
import com.example.LibraryManagementSystem.Services.Interfaces.AuthorService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    //add an author
    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorRequestDto authorDto) throws Exception
    {
        return authorService.addAuthor(authorDto);
    }

    //find author By Email
    @GetMapping("/getByEmail")
    public AuthorByEmailResponseDto getAuthorByEmail(@RequestParam("email") String email) throws Exception
    {
        return authorService.getAuthorByEmail(email);
    }

    //delete  author by id
    @DeleteMapping("/delete")
    public String deleteAuthor(@RequestParam("id") int id) throws Exception
    {
        return authorService.deleteAuthor(id);
    }
    //update author mobno by Id
    @PutMapping("/updateMobile")
    public UpdateMobileByIdResponseDto updateMobileOfAuthor(@RequestBody UpdateMobileByIdRequestDTo updateMobileByIdRequestDTo) throws Exception
    {
        return authorService.updateMobileOfAuthor(updateMobileByIdRequestDTo);
    }
    //find a author by Id
    @GetMapping("/getById")
    public AuthorResponseDto getById(@RequestParam("id") int id) throws Exception
    {
        return authorService.getById(id);
    }
    //find all authors
    @GetMapping("/getAllAuthors")
    public List<AuthorResponseDto> getAllAuthors() throws Exception
    {
        return authorService.getAllAuthors();
    }

}
