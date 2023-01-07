package com.example.springboot23.service.implementation;

import com.example.springboot23.entity.Book;
import com.example.springboot23.exception.BookNotFoundException;
import com.example.springboot23.repository.BookRepository;
import com.example.springboot23.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class BookServiceImpl implements BookService {


    private final BookRepository repository;

    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> fetchBooks() {
        return repository.findAll();
    }

    @Override
    public Book fetchBookById(Long id) throws BookNotFoundException {

        var bookFound = repository.findById(id);

        if (bookFound.isEmpty()){
            throw new BookNotFoundException("Book with id " + id + " not found");
        }

        return bookFound.get();
    }

    @Override
    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void saveOrUpdate(Book book, Long id) {
        Optional<Book> byId = repository.findById(id);
        Book bookToBeUpdated = byId.orElse(null);

        assert bookToBeUpdated != null;
        bookToBeUpdated.setBookName(book.getBookName());
        bookToBeUpdated.setBookTitle(book.getBookTitle());
        bookToBeUpdated.setBookAuthor(book.getBookAuthor());
        repository.save(bookToBeUpdated);
    }
}
