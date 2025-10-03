package com.example.demo.mapper;

import com.example.demo.dto.request.AuthorRequest;
import com.example.demo.dto.response.AuthorResponse;
import com.example.demo.entity.Author;


public enum AuthorMapper {
    AUTHOR_MAPPER;

    public Author requestToEntity(AuthorRequest authorRequest) {
        return Author.builder().fullName(authorRequest.getFullName()).
                country(authorRequest.getCountry()).build();

    }

    public AuthorResponse entityToResponse(Author author) {
        return AuthorResponse.builder().fullName(author.getFullName()).
                country(author.getCountry()).build();
    }
}
