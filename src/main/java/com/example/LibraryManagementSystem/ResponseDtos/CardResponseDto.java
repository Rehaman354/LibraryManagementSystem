package com.example.LibraryManagementSystem.ResponseDtos;


import com.example.LibraryManagementSystem.Enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CardResponseDto {

    private int id;

    private Date issueDate;

    private Date updatedOn;
    private Date expiryDate;


    private Status status;


}
