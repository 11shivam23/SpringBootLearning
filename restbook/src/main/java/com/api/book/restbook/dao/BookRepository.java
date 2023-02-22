package com.api.book.restbook.dao;

import org.springframework.data.repository.CrudRepository;
import com.api.book.restbook.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

    public Book findById(int id);
    
}
