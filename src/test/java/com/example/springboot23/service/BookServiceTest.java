package com.example.springboot23.service;

import com.example.springboot23.entity.Book;
import com.example.springboot23.exception.BookNotFoundException;
import com.example.springboot23.repository.BookRepository;
import com.example.springboot23.service.implementation.BookServiceImpl;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookService service;

    @Mock
    private  BookRepository repository;

    @Test
    @DisplayName("FindBookByIdTest")
    public void testFindBookById() throws BookNotFoundException {
        Book expectedBook = new Book();
        expectedBook.setBookId(1L);
        expectedBook.setBookName("Cracking Code Interview");
        expectedBook.setBookTitle("Code Interview");
        expectedBook.setBookAuthor("Mr Kevin");

        when(repository.findById(1L)).thenReturn(Optional.of(expectedBook));

       // when(service.fetchBookById(1L)).thenReturn(expectedBook);

        Book foundBook = service.fetchBookById(1L);

        assertEquals(foundBook.getBookId(), expectedBook.getBookId());

    }

}