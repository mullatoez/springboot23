package com.example.springboot23.service;

import com.example.springboot23.entity.Book;
import com.example.springboot23.exception.BookNotFoundException;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    List<Book> fetchBooks();

    Book fetchBookById(Long id) throws BookNotFoundException;

    void deleteBookById(Long id);

    void saveOrUpdate(Book book, Long id);
}
