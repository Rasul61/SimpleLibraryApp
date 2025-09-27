package com.example.demo.controller;

import com.example.demo.dto.request.AuthorRequest;
import com.example.demo.entity.Author;
import com.example.demo.service.abstraction.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    void addAuthor(@RequestBody AuthorRequest author){

        authorService.createAuthor(author);
    }
}
