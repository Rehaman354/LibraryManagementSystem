package com.example.LibraryManagementSystem.RequestDtos;

import com.example.LibraryManagementSystem.Enums.Department;
import com.example.LibraryManagementSystem.Enums.StudentYear;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddStudentRequestDto {

    private String name;
    private int age;

    private StudentYear year;
    private Department department;

    private String mobileNo;
    private String email;
}
