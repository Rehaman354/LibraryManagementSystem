package com.example.LibraryManagementSystem.RequestDtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthorRequestDto {
    private String name;
    private int age;

    private String mobileNo;

    private String email;
    private int rating;
}
