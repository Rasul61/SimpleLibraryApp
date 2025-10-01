package com.example.demo.repository;

import com.example.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByFullName(String fullName);

    List<Author> findByCountry(String country);

    Author findAuthorById(Long id);
}
