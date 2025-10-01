package com.example.demo.repository;

import com.example.demo.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowerRepository extends JpaRepository<Borrower,Long> {
    List<Borrower> findByName(String name);

    List<Borrower> findByEmail(String email);
}
