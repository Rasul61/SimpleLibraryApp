package com.example.demo.dto.response;

import com.example.demo.entity.Book;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BorrowerResponse {
    private String name;
    private String email;
    private List<Book> bookList;

}
