package com.example.demo.controller;

import com.example.demo.dto.request.BookRequest;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BorrowerRepository;
import com.example.demo.service.abstraction.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorRepository authorRepository;
    private final BorrowerRepository borrowerRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void addBook(@RequestBody BookRequest book) {
        bookService.createBook(book);
    }

    @GetMapping
    List<Book> findAllBook() {
        return bookService.getAllBooks();
    }

    @GetMapping("/id/{id}")
    BookResponse findById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/title/{title}")
    List<Book> getBooksByTitle(@PathVariable String title) {
        return bookService.findByTitle(title);
    }

    @GetMapping("/year/{year}")
    List<Book> getBooksByYear(@PathVariable Integer year) {
        return bookService.findByYear(year);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateBook(@PathVariable Long id, @RequestBody BookRequest bookRequest) {
        bookService.updateBook(id, bookRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable Long id) {
        bookService.deleteBook(id);
    }


}
