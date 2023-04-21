package com.example.LibraryManagementSystem.Services.Impl;

import com.example.LibraryManagementSystem.Entities.Card;
import com.example.LibraryManagementSystem.Entities.Student;
import com.example.LibraryManagementSystem.Enums.Status;
import com.example.LibraryManagementSystem.Exceptions.StudentNotFoundException;
import com.example.LibraryManagementSystem.Repositories.CardRepository;
import com.example.LibraryManagementSystem.Repositories.StudentRepository;
import com.example.LibraryManagementSystem.RequestDtos.AddStudentRequestDto;
import com.example.LibraryManagementSystem.RequestDtos.UpdateMobileByIdRequestDTo;
import com.example.LibraryManagementSystem.ResponseDtos.*;
import com.example.LibraryManagementSystem.Services.Interfaces.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public AddStudentResponseDto addStudent(AddStudentRequestDto studentDto) {
       //create student from addstudent dto
        Student student=new Student();
        student.setAge(studentDto.getAge());
        student.setDepartment(studentDto.getDepartment());
        student.setName(studentDto.getName());
        student.setYear(studentDto.getYear());
        student.setEmail(studentDto.getEmail());
        student.setMobileNo(studentDto.getMobileNo());

        // now generate card for a student
        Card card=new Card();
        card.setStatus(Status.ACTIVATED);
        //setting the expiry of card
            Calendar cal = Calendar.getInstance();//getting instance of cal now
            cal.add(Calendar.YEAR, 4);//adding four years to to this instance
        card.setExpiryDate(cal.getTime());
        card.setStudent(student);
        //add card to student
        student.setCard(card);
        //add student to student repo
       studentRepository.save(student);//crud operatioon will also apply to child
       //since it is a bidirectional mapping ,card gets automativally save in cardrepo
       //now form response dto
        AddStudentResponseDto addStudentResponseDto=new AddStudentResponseDto();
        addStudentResponseDto.setCardId(card.getId());
        return addStudentResponseDto;
    }

    @Override
    public UpdateMobileByIdResponseDto updateMobileById(UpdateMobileByIdRequestDTo updateMobileByIdRequestDTo) throws Exception {

        try {
           Student student = studentRepository.findById(updateMobileByIdRequestDTo.getId()).get();
            student.setMobileNo(updateMobileByIdRequestDTo.getNewMobileNo());
            studentRepository.save(student);
            UpdateMobileByIdResponseDto response=new UpdateMobileByIdResponseDto();
            response.setName(student.getName());
            response.setUpdatedMobile(student.getMobileNo());
            return response;
        }
        catch(Exception e)
        {
            throw new StudentNotFoundException("Student Not Found");
        }

    }

    @Override
    public GetStudentResponseDto getStudentById(int id) throws Exception {
        try {
            Student student = studentRepository.findById(id).get();
            GetStudentResponseDto response=new GetStudentResponseDto();
            response.setName(student.getName());
            response.setAge(student.getAge());
            response.setMobileNo(student.getMobileNo());
            response.setEmail(student.getEmail());
            response.setYear(student.getYear());
            response.setDepartment(student.getDepartment());

            CardResponseDto cardResponseDto=new CardResponseDto();
            cardResponseDto.setId(student.getCard().getId());
            cardResponseDto.setIssueDate(student.getCard().getIssueDate());
            cardResponseDto.setUpdatedOn(student.getCard().getUpdatedOn());
            cardResponseDto.setStatus(student.getCard().getStatus());
            cardResponseDto.setExpiryDate(student.getCard().getExpiryDate());

            response.setCardResponseDto(cardResponseDto);
            return response;
        }
        catch(Exception e)
        {
            throw new StudentNotFoundException("Student id Not found");
        }

    }

    @Override
    public List<GetStudentResponseDto> getAllStudents() throws Exception {
        List<Student> students=studentRepository.findAll();
        List<GetStudentResponseDto> response=new ArrayList<>();
        for(Student student:students)
        {
            int id=student.getId();
           response.add(getStudentById(id));
        }
        return response;
    }

    @Override
    public DeleteStudentResponseDto deleteStudent(int id) throws Exception {
        Student student;
        DeleteStudentResponseDto response;
        try {
            student = studentRepository.findById(id).get();
        } catch (Exception e) {
            throw new StudentNotFoundException("Student not found");
        }
        Card card = cardRepository.findById(student.getCard().getId()).get();
        int cardBooks=card.getBooks().size();
            if (cardBooks != 0)
                throw new Exception("Student card some books to return,so pls return the books ");

        response = new DeleteStudentResponseDto();
        response.setCardid(student.getCard().getId());
        response.setStudentid(student.getId());
        studentRepository.deleteById(id);

        return response;
    }
}
