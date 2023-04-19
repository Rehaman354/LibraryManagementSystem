package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.RequestDtos.IssueBookRequestDto;
import com.example.LibraryManagementSystem.ResponseDtos.IssueBookResponseDto;
import com.example.LibraryManagementSystem.Services.Interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

 @PostMapping("/issueBook")
 public IssueBookResponseDto issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception
 {
     return transactionService.issueBook(issueBookRequestDto);
 }
    @PostMapping("/returnBook")
    public IssueBookResponseDto returnBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception
    {
        return transactionService.returnBook(issueBookRequestDto);
    }
}
