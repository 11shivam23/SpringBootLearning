package com.api.book.restbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.restbook.dao.BookRepository;
import com.api.book.restbook.entities.Book;

@Service
public class BookService {
    
    private static List<Book> list = new ArrayList<>();

    @Autowired
    BookRepository bookRepository;

    static {
        list.add(new Book(1, "Rich Dad", "piyush"));
        list.add(new Book(2, "Poor Dad", "Akashay"));
        list.add(new Book(3, "Avg Dad", "Pranav"));
    }

    //getAllBooks
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>)this.bookRepository.findAll();
        return list;
    }

    //getSingleBook
    public Book getBookById(int id) {
        Book book = null;
        try{
            // book = list.stream().filter(e->e.getId()==id).findFirst().get();

            book = this.bookRepository.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    //adding the book
    public Book addBook(Book b) {
        // list.add(b);

        this.bookRepository.save(b);

        return b;
    }

    //deleting a book
    public void deleteBook(int id) {
        // list = list.stream().filter(book->book.getId() != id).collect(Collectors.toList());

        this.bookRepository.deleteById(id);
    }

    public void updateBook(int id, Book book) {
        // list = list.stream().map(b->{
        //     if(b.getId() == book.getId()) {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());

        book.setId(id);
        this.bookRepository.save(book);
    }




}
