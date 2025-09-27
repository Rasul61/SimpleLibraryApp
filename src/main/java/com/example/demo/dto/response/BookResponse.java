package com.example.demo.dto.response;

import com.example.demo.entity.Author;
import com.example.demo.entity.Borrower;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponse {
    private String title;
    private int year;
    private Author author;
    private Borrower borrower;
}
