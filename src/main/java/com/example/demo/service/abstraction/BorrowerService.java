package com.example.demo.service.abstraction;

import com.example.demo.dto.request.BorrowerRequest;
import com.example.demo.dto.response.BorrowerResponse;
import com.example.demo.entity.Borrower;

import java.util.List;
import java.util.Optional;

public interface BorrowerService {
    void createBorrower(BorrowerRequest borrower);

    List<BorrowerResponse> getAllBorrower();

    BorrowerResponse getById(Long id);

    BorrowerResponse getByName(String name);

    BorrowerResponse getByEmail(String email);

    void updateBorrower(Long id, BorrowerRequest borrower);

    void deleteBorrower(Long id);
}
