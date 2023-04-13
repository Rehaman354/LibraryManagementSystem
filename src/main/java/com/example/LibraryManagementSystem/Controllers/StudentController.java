package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.Entities.Student;
import com.example.LibraryManagementSystem.Services.Interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }
    //delete student by id
    //update student by Id
    //find a student by Id
    //find all students
}
