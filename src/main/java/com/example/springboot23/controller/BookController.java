package com.example.springboot23.controller;

import com.example.springboot23.entity.Book;
import com.example.springboot23.exception.BookNotFoundException;
import com.example.springboot23.repository.BookRepository;
import com.example.springboot23.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RequiredArgsConstructor
@RestController
@RequestMapping("/api") //localhost:8080/api/list
public class BookController {

    private final BookService service;
    private final BookRepository repository;

    //CRUD ---
    //POST PostMapping -- Creating new records/data
    //GET GetMapping
    //PUT PutMapping -- Updating
    //DELETE DeleteMapping


    @PostMapping("/book")
    public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book) {
        return ResponseEntity.ok(service.saveBook(book));
    }

    @GetMapping("/booksList") //GET,DELETE,POST,PUT
    public List<Book> fetchBooks() {
        log.info("Fetching books...... "); //logs observation
        return service.fetchBooks();
    }

    @GetMapping("/book/{id}")
    public Book fetchBookById(@PathVariable Long id) throws BookNotFoundException {
        return service.fetchBookById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBookById(@PathVariable Long id) {

        var depId = repository.findById(id);

        if (depId.isPresent()) {
            service.deleteBookById(id);
            return "Book of id " + id + " deleted successfully";
        }

        return "Book of id " + id + " not found!";
    }

    @PutMapping("/updateBook/{id}")
    private Book update(@RequestBody Book book, @PathVariable Long id) {
        var depId = repository.findById(id);
        if (depId.isPresent()) {
            service.saveOrUpdate(book, id);
            return book;
        }
        return null;
    }
}
