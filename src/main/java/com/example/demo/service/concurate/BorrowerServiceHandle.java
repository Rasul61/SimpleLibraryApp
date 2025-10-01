package com.example.demo.service.concurate;

import com.example.demo.dto.request.BorrowerRequest;
import com.example.demo.entity.Borrower;
import com.example.demo.repository.BorrowerRepository;
import com.example.demo.service.abstraction.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.mapper.BorrowerMapper.BORROWER_MAPPER;

@Service
@RequiredArgsConstructor
public class BorrowerServiceHandle implements BorrowerService {
    private final BorrowerRepository borrowerRepository;

    @Override
    public void createBorrower(BorrowerRequest borrower) {
        Borrower borrower1 = BORROWER_MAPPER.requestToEntity(borrower);
        borrowerRepository.save(borrower1);
    }

    @Override
    public List<Borrower> getAllBorrower() {
        return borrowerRepository.findAll();
    }

    @Override
    public List<Borrower> getByName(String name) {
        return borrowerRepository.findByName(name);
    }

    @Override
    public List<Borrower> getByEmail(String email) {
        return borrowerRepository.findByEmail(email);
    }

    @Override
    public void updateBorrower(Long id, Borrower borrower) {
        Borrower borrower1 = borrowerRepository.findById(id).get();
        borrower.setName(borrower1.getName());
        borrower.setEmail(borrower1.getEmail());
        borrowerRepository.save(borrower1);
    }

    @Override
    public void deleteBorrower(Long id) {
        Borrower borrower = borrowerRepository.findById(id).get();
        borrowerRepository.delete(borrower);


    }
}
