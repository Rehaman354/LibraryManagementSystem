package com.example.LibraryManagementSystem.Services.Interfaces;

import com.example.LibraryManagementSystem.RequestDtos.IssueBookRequestDto;
import com.example.LibraryManagementSystem.ResponseDtos.IssueBookResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

     IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;

     IssueBookResponseDto returnBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
