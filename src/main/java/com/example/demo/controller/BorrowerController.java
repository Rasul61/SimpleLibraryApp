package com.example.demo.controller;

import com.example.demo.dto.request.BorrowerRequest;
import com.example.demo.entity.Borrower;
import com.example.demo.service.abstraction.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/borrower")
public class BorrowerController {
    private final BorrowerService borrowerService;

    @PostMapping
    void addBorrower(@RequestBody BorrowerRequest borrower) {
        borrowerService.createBorrower(borrower);
    }
}
