package com.example.demo.service.concurate;

import com.example.demo.dto.request.AuthorRequest;
import com.example.demo.dto.response.AuthorResponse;
import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.abstraction.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.mapper.AuthorMapper.AUTHOR_MAPPER;

@Service
@RequiredArgsConstructor
public class AuthorServiceHandle implements AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public void createAuthor(AuthorRequest author) {
        Author author1 = AUTHOR_MAPPER.requestToEntity(author);
        authorRepository.save(author1);

    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> findByCountry(String country) {
        return authorRepository.findByCountry(country);
    }

    @Override
    public List<Author> findByFullName(String fullname) {
        return authorRepository.findByFullName(fullname);
    }

    @Override
    public void updateAuthor(Long id, AuthorRequest authorRequest) {
        Author author = authorRepository.findById(id).get();
        author.setFullName(authorRequest.getFullName());
        author.setCountry(authorRequest.getCountry());
        authorRepository.save(author);


    }

    @Override
    public AuthorResponse getAuthorById(Long id) {
        Author author = authorRepository.findAuthorById(id);
        return AUTHOR_MAPPER.entityToResponse(author);


    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).get();
        authorRepository.delete(author);
    }
}
