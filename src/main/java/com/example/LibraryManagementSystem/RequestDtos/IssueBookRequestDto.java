package com.example.LibraryManagementSystem.RequestDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class IssueBookRequestDto {
    private int bookid;
    private int cardid;
}
