package com.example.demo.dto.response;

import com.example.demo.entity.Book;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AuthorResponse {
    private String fullName;
    private String country;
}
