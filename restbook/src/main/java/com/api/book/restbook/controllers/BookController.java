package com.api.book.restbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

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

    // @GetMapping("/allBooks")
    // public List<Book> getAllBooks() {
    //     return bookService.getAllBooks();
    // }

    @GetMapping("/allBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = bookService.getAllBooks();
        if(list.size()<=0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    // @GetMapping("/singleBook/{id}")
    // public Book getBook(@PathVariable("id") int id) {
    //     return bookService.getBookById(id);
    // }

    @GetMapping("/singleBook/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        if(book==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

//    @PostMapping("/addBook")
//    public Book addBook(@RequestBody Book book) {
//         return bookService.addBook(book);
//    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book b = null;
        try {
            b = this.bookService.addBook(b);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    @DeleteMapping("/deleteBook/{id}")
//    public void deleteBook(@PathVariable("id") int id) {
//         bookService.deleteBook(id);
//    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    @PutMapping("/updateBook/{id}")
//    public Book updateBook(@PathVariable("id") int id, @RequestBody Book book) {
//         this.bookService.updateBook(id, book);
//         return book;
//    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        try{
            this.bookService.updateBook(id, book);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
