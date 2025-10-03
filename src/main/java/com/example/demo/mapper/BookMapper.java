package com.example.demo.mapper;

import com.example.demo.dto.request.BookRequest;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BorrowerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookMapper {

    //BOOK_MAPPER;
    private final AuthorRepository authorRepository;
    private final BorrowerRepository borrowerRepository;

    public BookResponse entityToResponse(Book book) {
        return BookResponse.builder().title(book.getTitle()).
                year(book.getYear()).author(book.getAuthor()).
                borrower(book.getBorrower()).build();
    }

    public Book requestToEntity(BookRequest bookRequest) {
        return Book.builder().title(bookRequest.getTitle()).
                year(bookRequest.getYear()).
                author(authorRepository.findAuthorById(bookRequest.getAuthorId())).
                borrower(borrowerRepository.findById(bookRequest.getBorrowerId()).
                        orElseThrow(() -> new RuntimeException("Don't find borrower with this ID"))).
                build();
    }


}
