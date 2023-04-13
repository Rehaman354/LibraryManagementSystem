package com.example.LibraryManagementSystem.Repositories;

import com.example.LibraryManagementSystem.Entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
