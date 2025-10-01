package com.example.demo.dto.request;

import com.example.demo.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class BorrowerRequest {
    private String name;
    private String email;
    //private List<Book> bookList;
}
