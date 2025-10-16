package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "borrowers")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String email;

    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Book> bookList;
}
