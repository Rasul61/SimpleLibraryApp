package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "books")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    int year;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
   // @JsonIgnore
    Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "borrower_id")
   // @JsonIgnore

    Borrower borrower;
}
