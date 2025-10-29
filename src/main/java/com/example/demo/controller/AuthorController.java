package com.example.demo.controller;

import com.example.demo.dto.request.AuthorRequest;
import com.example.demo.dto.response.AuthorResponse;
import com.example.demo.entity.Author;
import com.example.demo.service.abstraction.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void addAuthor(@RequestBody AuthorRequest author) {
        authorService.createAuthor(author);
    }

    @GetMapping
    List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/name/{name}")
    List<Author> getByName(@PathVariable String name) {
        return authorService.findByFullName(name);
    }

    @GetMapping("/country/{country}")
    List<Author> getByCountry(@PathVariable String country) {
        return authorService.findByCountry(country);
    }

    @GetMapping("/id/{id}")
    AuthorResponse getById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateAuthors(@PathVariable Long id, @RequestBody AuthorRequest author) {
        authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
