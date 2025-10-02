package com.example.demo.controller;

import com.example.demo.dto.request.BorrowerRequest;
import com.example.demo.dto.response.BorrowerResponse;
import com.example.demo.entity.Borrower;
import com.example.demo.service.abstraction.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/borrower")
public class BorrowerController {
    private final BorrowerService borrowerService;

    @PostMapping
    void addBorrower(@RequestBody BorrowerRequest borrower) {
        borrowerService.createBorrower(borrower);
    }

    @GetMapping
    Optional<Borrower> findWithId(@PathVariable Long id) {
        return borrowerService.getById(id);
    }

    @GetMapping
    BorrowerResponse findWithName(@PathVariable String name) {
        return borrowerService.getByName(name);
    }

    @GetMapping
    List<Borrower> findAll(){
       return borrowerService.getAllBorrower();
    }

    @GetMapping
    BorrowerResponse findWithEmail(@PathVariable String email) {
        return borrowerService.getByEmail(email);
    }

    @PutMapping
    public void updateBorrowers(@PathVariable Long id, @RequestBody BorrowerRequest borrowerRequest) {
        borrowerService.updateBorrower(id, borrowerRequest);
    }

    @DeleteMapping
    public void deleteBorrowers(@PathVariable Long id){
        borrowerService.deleteBorrower(id);
    }


}
