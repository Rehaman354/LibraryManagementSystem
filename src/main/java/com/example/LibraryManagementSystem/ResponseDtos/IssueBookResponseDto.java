package com.example.LibraryManagementSystem.ResponseDtos;

import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class IssueBookResponseDto {
    private String transactionNo;
    private TransactionStatus transactionStatus;
    private String bookName;
}
