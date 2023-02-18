package com.api.book.restbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.book.restbook.entities.Book;

@Service
public class BookService {
    
    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(1, "Rich Dad", "piyush"));
        list.add(new Book(2, "Poor Dad", "Akashay"));
        list.add(new Book(3, "Avg Dad", "Pranav"));
    }

    //getAllBooks
    public List<Book> getAllBooks() {
        return list;
    }

    //getSingleBook
    public Book getBookById(int id) {
        Book book = null;
        book = list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }

    //adding the book
    public Book addBook(Book b) {
        list.add(b);
        return b;
    }

    //deleting a book
    public void deleteBook(int id) {
        list = list.stream().filter(book->book.getId() != id).collect(Collectors.toList());
        
    }
}
