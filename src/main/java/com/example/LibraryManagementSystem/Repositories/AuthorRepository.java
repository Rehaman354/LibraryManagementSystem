package com.example.LibraryManagementSystem.Repositories;

import com.example.LibraryManagementSystem.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
