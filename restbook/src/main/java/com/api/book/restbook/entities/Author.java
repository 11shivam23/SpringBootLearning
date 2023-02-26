package com.api.book.restbook.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="authors")
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String firstName;
    
    private String lastName;
    
    private String language;

    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;

    public Author() {
    }

    public Author(int id, String firstName, String lastName, String language, Book book) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
        this.book = book;
    }

    public int getAuthorId() {
        return id;
    }
    public void setAuthorId(int authorId) {
        this.id = authorId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author [authorId=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", language="
                + language + ", book=" + book + "]";
    }
    
}
