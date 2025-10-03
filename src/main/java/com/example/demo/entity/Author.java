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
@Table(name = "authors")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String fullName;
    String country;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    List<Book> bookList;


}
