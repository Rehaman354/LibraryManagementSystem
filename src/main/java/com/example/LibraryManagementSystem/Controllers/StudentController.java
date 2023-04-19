package com.example.LibraryManagementSystem.Controllers;


import com.example.LibraryManagementSystem.RequestDtos.AddStudentRequestDto;
import com.example.LibraryManagementSystem.RequestDtos.UpdateMobileByIdRequestDTo;
import com.example.LibraryManagementSystem.ResponseDtos.AddStudentResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.DeleteStudentResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.GetStudentResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.UpdateMobileByIdResponseDto;
import com.example.LibraryManagementSystem.Services.Interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    //addind new student api
    @PostMapping("/add")
    public AddStudentResponseDto addStudent(@RequestBody AddStudentRequestDto student)
    {
        return studentService.addStudent(student);
    }
    //update student mobileNo by his id if he is present ion records api
    @PutMapping("/updateMobile")
    public UpdateMobileByIdResponseDto updateMobileById(@RequestBody UpdateMobileByIdRequestDTo updateMobileByIdRequestDTo) throws Exception
    {
        return studentService.updateMobileById(updateMobileByIdRequestDTo);
    }
    //delete student by id
    @DeleteMapping("/delete")
    public DeleteStudentResponseDto deleteStudent(@RequestParam("Id") int id) throws Exception
    {
        return studentService.deleteStudent(id);
    }
    //find a student by Id
    @GetMapping("/getStudentById")
    public GetStudentResponseDto getStudentById(@RequestParam("id") int id) throws Exception
    {
        return studentService.getStudentById(id);
    }
    //find all students
    @GetMapping("/getAllStudents")
    public List<GetStudentResponseDto> getAllStudentts() throws Exception
    {
        return studentService.getAllStudents();
    }
}
