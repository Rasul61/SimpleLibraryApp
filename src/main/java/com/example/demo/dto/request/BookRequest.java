package com.example.demo.dto.request;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private int year;
    private Long authorId;
    private Long borrowerId;
}
