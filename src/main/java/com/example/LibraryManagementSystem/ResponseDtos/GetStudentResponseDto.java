package com.example.LibraryManagementSystem.ResponseDtos;

import com.example.LibraryManagementSystem.Entities.Card;
import com.example.LibraryManagementSystem.Enums.Department;
import com.example.LibraryManagementSystem.Enums.StudentYear;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetStudentResponseDto {

    private String name;
    private int age;

    private StudentYear year;
    private Department department;

    private String mobileNo;
    private String email;


    private CardResponseDto cardResponseDto;
}
