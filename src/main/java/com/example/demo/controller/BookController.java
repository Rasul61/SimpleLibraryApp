package com.example.demo.controller;

import com.example.demo.dto.request.BookRequest;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Borrower;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BorrowerRepository;
import com.example.demo.service.abstraction.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorRepository authorRepository;
    private final BorrowerRepository borrowerRepository;

    @PostMapping
    void addBook(@RequestBody BookRequest book) {
        bookService.createBook(book);
    }

    @GetMapping("/{id}")
    Book findBook(@PathVariable Long id) {
        return bookService.getBookById(id);
    }


}
