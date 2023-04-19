package com.example.LibraryManagementSystem.RequestDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateMobileByIdRequestDTo {
    private int id;
    private String newMobileNo;
}
