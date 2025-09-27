package com.example.demo.mapper;

import com.example.demo.dto.request.BorrowerRequest;
import com.example.demo.dto.response.BorrowerResponse;
import com.example.demo.entity.Borrower;

public enum BorrowerMapper {
    BORROWER_MAPPER;

    public Borrower requestToEntity(BorrowerRequest borrowerRequest) {
        return Borrower.builder().name(borrowerRequest.getName()).
                email(borrowerRequest.getEmail()).
                bookList(borrowerRequest.getBookList()).build();
    }

    public BorrowerResponse entityToResponse(Borrower borrower) {
        return BorrowerResponse.builder().name(borrower.getName()).
                email(borrower.getEmail()).bookList(borrower.getBookList()).build();
    }

}
