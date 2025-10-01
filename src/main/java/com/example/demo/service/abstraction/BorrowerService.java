package com.example.demo.service.abstraction;

import com.example.demo.dto.request.BorrowerRequest;
import com.example.demo.entity.Borrower;

import java.util.List;

public interface BorrowerService {
    void createBorrower(BorrowerRequest borrower);
    List<Borrower> getAllBorrower();
    List<Borrower> getByName(String name);
    List<Borrower> getByEmail(String email);
    void updateBorrower(Long id,Borrower borrower);
    void deleteBorrower(Long id);
}
