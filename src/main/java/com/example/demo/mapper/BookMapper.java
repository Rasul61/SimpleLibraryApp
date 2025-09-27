package com.example.demo.mapper;

import com.example.demo.dto.request.BookRequest;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


public enum BookMapper {

    BOOK_MAPPER;

    public BookResponse entityToResponse(Book book) {
        return BookResponse.builder().title(book.getTitle()).
                year(book.getYear()).author(book.getAuthor()).
                borrower(book.getBorrower()).build();
    }

    public Book requestToEntity(BookRequest bookRequest) {
        return Book.builder().title(bookRequest.getTitle()).
                year(bookRequest.getYear()).
                build();
    }
}
