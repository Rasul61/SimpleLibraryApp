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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id") // внешний ключ
//    @JsonIgnore
    Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_id")
    //    @JsonIgnore

    Borrower borrower;
}
