package com.example.demo.service.abstraction;

import com.example.demo.dto.request.BookRequest;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.entity.Book;

import java.util.List;

public interface BookService {
    void createBook(BookRequest book);

    List<BookResponse> getAllBooks();

    List<BookResponse> findByTitle(String title);

    List<BookResponse> findByYear(Integer year);

    void updateBook(Long id, BookRequest book);

    BookResponse getBookById(Long id);

    void deleteBook(Long id);

}
