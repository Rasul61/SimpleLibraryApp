package com.example.demo.service.concurate;

import com.example.demo.dto.request.BookRequest;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Borrower;
import com.example.demo.mapper.BookMapper;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BorrowerRepository;
import com.example.demo.service.abstraction.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.mapper.BookMapper.entityToResponse;



@Service
@RequiredArgsConstructor
public class BookServiceHandle implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BorrowerRepository borrowerRepository;
    BookMapper bookMapper;

    @Override
    public void createBook(BookRequest bookRequest) {
        Book book = bookMapper.requestToEntity(bookRequest);
        Author author = authorRepository.findById(bookRequest.getAuthorId())
                .orElseThrow(RuntimeException::new);
        Borrower borrower = borrowerRepository.findById(bookRequest.getBorrowerId()).
                orElseThrow(() -> new RuntimeException("Could not find an borrower with this ID"));
        book.setAuthor(author);
        book.setBorrower(borrower);

        bookRepository.save(book);
    }

    @Override
    public List<BookResponse> getAllBooks() {

        return bookRepository.findAll().stream().
                map(BookMapper::entityToResponse).
                toList();
    }

    @Override
    public BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Could not find an author with this ID"));

        return entityToResponse(book);

    }

    @Override
    public List<BookResponse> findByTitle(String title) {

        return bookRepository.findByTitle(title).stream().
                map(BookMapper::entityToResponse).
                toList();
    }

    @Override
    public List<BookResponse> findByYear(Integer year) {

        return bookRepository.findByYear(year).stream().
                map(BookMapper::entityToResponse).
                toList();
    }

    @Override
    public void updateBook(Long id, BookRequest book) {
        Book book1 = bookRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Could not find an book with this ID for updating"));
        Author author1 = authorRepository.findAuthorById(book.getAuthorId());
        Borrower borrower1 = borrowerRepository.findById(book.getBorrowerId()).
                orElseThrow(() -> new RuntimeException("Could not find an borrower with this ID for updating"));
        ;

        book1.setTitle(book.getTitle());
        book1.setYear(book.getYear());
        book1.setAuthor(author1);
        book1.setBorrower(borrower1);
        bookRepository.save(book1);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }
}
