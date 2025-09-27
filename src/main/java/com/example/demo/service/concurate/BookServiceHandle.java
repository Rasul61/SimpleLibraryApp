package com.example.demo.service.concurate;

import com.example.demo.dto.request.BookRequest;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Borrower;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BorrowerRepository;
import com.example.demo.service.abstraction.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.mapper.BookMapper.BOOK_MAPPER;

@Service
@RequiredArgsConstructor
public class BookServiceHandle implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BorrowerRepository borrowerRepository;

    @Override
    public void createBook(BookRequest bookRequest) {
        Book book = BOOK_MAPPER.requestToEntity(bookRequest);
        Author author = authorRepository.findById(bookRequest.getAuthorId())
                .orElseThrow(RuntimeException::new);
        Borrower borrower = borrowerRepository.findById(bookRequest.getBorrowerId()).get();
        book.setAuthor(author);
        book.setBorrower(borrower);

        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByTitle(String title) {

        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> findByYear(int year) {

        return bookRepository.findByYear(year);
    }

    @Override
    public void updateBook(Long id, Book book) {
        Book book1 = bookRepository.findById(id).get();
        book1.setTitle(book.getTitle());
        book1.setYear(book.getYear());
        book1.setAuthor(book.getAuthor());
        book1.setBorrower(book.getBorrower());
        bookRepository.save(book1);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();

    }

    @Override
    public void deleteBook(Long id) {


    }
}
