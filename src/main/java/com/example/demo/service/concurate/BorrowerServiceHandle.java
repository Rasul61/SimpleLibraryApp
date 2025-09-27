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
        Borrower borrower1=BORROWER_MAPPER.requestToEntity(borrower);
        borrowerRepository.save(borrower1);
    }

    @Override
    public List<Borrower> getAllBorrower() {
        return List.of();
    }

    @Override
    public List<Borrower> getByName(String name) {
        return List.of();
    }

    @Override
    public List<Borrower> getByEmail(String email) {
        return List.of();
    }

    @Override
    public void updateBorrower(Borrower borrower) {

    }

    @Override
    public void deleteBorrower(Long id) {

    }
}
