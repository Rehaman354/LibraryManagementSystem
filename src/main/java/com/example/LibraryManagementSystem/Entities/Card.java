package com.example.LibraryManagementSystem.Entities;

import com.example.LibraryManagementSystem.Enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//it will be automatically generated
    @CreationTimestamp
    private Date issueDate;//it will also generated automatically
    @UpdateTimestamp
    private Date updatedOn;
    private Date expiryDate;
    ////we need to set below parameters
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne
    @JoinColumn
    private Student student;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transaction> transactions=new ArrayList<>();

    @OneToMany(mappedBy= "card",cascade=CascadeType.ALL)
    private  List<Book> books=new ArrayList<>();
    //


}
