package com.example.springboot.springbootwithpostgressgraphql.services;

import com.example.springboot.springbootwithpostgressgraphql.models.Book;
import com.example.springboot.springbootwithpostgressgraphql.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooks() { return bookRepository.findAll(); }

    public Book createBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public Book updateBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public boolean deleteBook(Integer id) {
        bookRepository.deleteById(id);
        return true;
    }
}
