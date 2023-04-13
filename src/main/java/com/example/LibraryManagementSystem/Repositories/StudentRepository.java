package com.example.LibraryManagementSystem.Repositories;

import com.example.LibraryManagementSystem.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
