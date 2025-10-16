package com.example.demo.controller;

import com.example.demo.dto.request.BorrowerRequest;
import com.example.demo.dto.response.BorrowerResponse;
import com.example.demo.entity.Borrower;
import com.example.demo.service.abstraction.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/borrower")
public class BorrowerController {
    private final BorrowerService borrowerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void addBorrower(@RequestBody BorrowerRequest borrower) {
        borrowerService.createBorrower(borrower);
    }

    @GetMapping("/id/{id}")
    Optional<Borrower> findWithId(@PathVariable Long id) {
        return borrowerService.getById(id);
    }

    @GetMapping("/name/{name}")
    BorrowerResponse findWithName(@PathVariable String name) {
        return borrowerService.getByName(name);
    }

    @GetMapping
    List<Borrower> findAll() {
        return borrowerService.getAllBorrower();
    }

    @GetMapping("/email/{email}")
    BorrowerResponse findWithEmail(@PathVariable String email) {
        return borrowerService.getByEmail(email);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBorrowers(@PathVariable Long id, @RequestBody BorrowerRequest borrowerRequest) {
        borrowerService.updateBorrower(id, borrowerRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBorrowers(@PathVariable Long id) {
        borrowerService.deleteBorrower(id);
    }


}
