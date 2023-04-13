package com.example.LibraryManagementSystem.Entities;

import com.example.LibraryManagementSystem.Enums.Department;
import com.example.LibraryManagementSystem.Enums.StudentYear;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//it will get automatically generated

    //user has to give these below 6 parameters to add a new student
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private StudentYear year;
    @Enumerated(EnumType.STRING)
    private Department department;
    private String mobileNo;
    private String email;//

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;//it will also we will generate by us when student is generated
}
