package com.api.book.restbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.restbook.entities.Book;
import com.api.book.restbook.services.BookService;

// @Controller  
@RestController  //if we are using restcontroller then there is no need of @ResponseBody Annootation
public class BookController {

    @Autowired
    private BookService bookService;

    // @RequestMapping(value = "/books", method = RequestMethod.GET)
    // @ResponseBody    
    @GetMapping("/books")
    public String getBooks() {
        return "this is testing book first";
    }

    @GetMapping("/bookObject")
    public Book getBookObject() {

        Book book = new Book();
        book.setId(0);
        book.setTitle("Java Complete Reference");
        book.setAuthor("Shivam");
        return book;
    }

    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/singleBook/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

   @PostMapping("/addBook")
   public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
   }

   @DeleteMapping("/deleteBook/{id}")
   public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
   }
}
