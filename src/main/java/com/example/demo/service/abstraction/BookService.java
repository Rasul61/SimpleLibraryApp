package com.example.demo.service.abstraction;

import com.example.demo.dto.request.BookRequest;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.entity.Book;

import java.util.List;

public interface BookService {
    void createBook(BookRequest book);

    List<Book> getAllBooks();

    List<Book> findByTitle(String title);

    List<Book> findByYear(Integer year);

    void updateBook(Long id, BookRequest book);

    BookResponse getBookById(Long id);

    void deleteBook(Long id);

}
