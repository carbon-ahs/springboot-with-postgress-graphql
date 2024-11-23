package com.example.springboot.springbootwithpostgressgraphql.repositories;

import com.example.springboot.springbootwithpostgressgraphql.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
