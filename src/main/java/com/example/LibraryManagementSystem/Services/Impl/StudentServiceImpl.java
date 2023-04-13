package com.example.LibraryManagementSystem.Services.Impl;

import com.example.LibraryManagementSystem.Entities.Card;
import com.example.LibraryManagementSystem.Entities.Student;
import com.example.LibraryManagementSystem.Enums.Status;
import com.example.LibraryManagementSystem.Repositories.StudentRepository;
import com.example.LibraryManagementSystem.Services.Interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(Student student) {
        //generate card for a student
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
       return "Student added successfully";
    }
}
