package it.eomm.hello.jdo.model;

import javax.jdo.annotations.PersistenceCapable;

/**
 * Created by Manuel Spigolon on 07/05/2017.
 */
@PersistenceCapable
public class Book extends Product {

    private String author = null;

    private String isbn = null;

    private String publisher = null;

    public Book(String name, String desc, double price, String author, String isbn, String publisher) {
        super(name, desc, price);
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
