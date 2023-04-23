package com.example.LibraryManagementSystem.ResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdatePriceResponseDto {
    private String bookTitle;
    private int oldprice;
    private int updatedPrice;
}
