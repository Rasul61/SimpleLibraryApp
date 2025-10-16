package com.example.demo.service.concurate;

import com.example.demo.dto.request.BorrowerRequest;
import com.example.demo.dto.response.BorrowerResponse;
import com.example.demo.entity.Borrower;
import com.example.demo.repository.BorrowerRepository;
import com.example.demo.service.abstraction.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Borrower> getById(Long id) {
        return borrowerRepository.findById(id);
    }

    @Override
    public BorrowerResponse getByName(String name) {
        return (BorrowerResponse) borrowerRepository.findByName(name);
    }

    @Override
    public BorrowerResponse getByEmail(String email) {
        return (BorrowerResponse) borrowerRepository.findByEmail(email);
    }


    @Override
    public void updateBorrower(Long id, BorrowerRequest borrower) {
        Borrower borrower1 = borrowerRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Could not find an borrower with this ID for updating"));
        borrower1.setName(borrower.getName());
        borrower1.setEmail(borrower.getEmail());
        borrowerRepository.save(borrower1);
    }

    @Override
    public void deleteBorrower(Long id) {
        Borrower borrower = borrowerRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Could not find an borrower with this ID for deleting"));
        borrowerRepository.delete(borrower);


    }
}
