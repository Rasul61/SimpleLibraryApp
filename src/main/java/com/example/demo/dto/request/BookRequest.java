package com.example.demo.dto.request;

import com.example.demo.entity.Author;
import com.example.demo.entity.Borrower;
import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private int year;
    private Long authorId;
    private Long borrowerId;
}
