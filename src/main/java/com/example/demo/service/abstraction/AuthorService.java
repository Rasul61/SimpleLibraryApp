package com.example.demo.service.abstraction;

import com.example.demo.dto.request.AuthorRequest;
import com.example.demo.dto.response.AuthorResponse;
import com.example.demo.entity.Author;

import java.util.List;

public interface AuthorService {
    void createAuthor(AuthorRequest author);

    List<Author> getAllAuthors();

    List<Author> findByCountry(String country);

    List<Author> findByFullName(String fullname);

    void updateAuthor(Long id, AuthorRequest authorRequest);

    AuthorResponse getAuthorById(Long id);

    void deleteAuthor(Long id);


}
