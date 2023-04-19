package com.example.LibraryManagementSystem.Services.Interfaces;

import com.example.LibraryManagementSystem.Entities.Student;
import com.example.LibraryManagementSystem.RequestDtos.AddStudentRequestDto;
import com.example.LibraryManagementSystem.RequestDtos.UpdateMobileByIdRequestDTo;
import com.example.LibraryManagementSystem.ResponseDtos.AddStudentResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.DeleteStudentResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.GetStudentResponseDto;
import com.example.LibraryManagementSystem.ResponseDtos.UpdateMobileByIdResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
     AddStudentResponseDto addStudent(AddStudentRequestDto student);

     UpdateMobileByIdResponseDto updateMobileById(UpdateMobileByIdRequestDTo updateMobileByIdRequestDTo) throws Exception;

    GetStudentResponseDto getStudentById(int id) throws Exception;

    List<GetStudentResponseDto> getAllStudents() throws Exception;


    DeleteStudentResponseDto deleteStudent(int id) throws Exception;
}
