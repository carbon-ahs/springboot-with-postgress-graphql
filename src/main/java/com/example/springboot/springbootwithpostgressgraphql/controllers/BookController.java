package com.example.springboot.springbootwithpostgressgraphql.controllers;

import com.example.springboot.springbootwithpostgressgraphql.models.Book;
import com.example.springboot.springbootwithpostgressgraphql.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @QueryMapping
    public Optional<Book> bookById(@Argument Integer id) {
        return bookService.getBookById(id);
    }

    @QueryMapping
    public List<Book> allBooks() {
        return bookService.getAllBooks();
    }

    @MutationMapping
    public void createBook(@Argument String name, @Argument Integer pageCount) {
        Book book = new Book();
        book.setName(name);
        book.setPageCount(pageCount);
        bookService.createBook(book);
    }

    @MutationMapping
    public Book updateBook(@Argument Integer id, @Argument String name, @Argument Integer pageCount) {
        Book book = new Book();
        Optional<Book> optionalBook = bookService.getBookById(id);
        if(optionalBook.isPresent()) {
            book = optionalBook.get();
            book.setName(name);
            book.setPageCount(pageCount);
        } else {
            throw new IllegalArgumentException("Invalid Id");
        }



        return bookService.updateBook(book);
    }

    @MutationMapping
    public boolean deleteBook(@Argument Integer id) {
        return bookService.deleteBook(id);
    }


}
