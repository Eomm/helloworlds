package it.eomm.hello.jdo.model;

import javax.jdo.annotations.PersistenceCapable;

/**
 * Created by Manuel Spigolon on 07/05/2017.
 */
@PersistenceCapable
public class Book extends Product {
    String author = null;
    String isbn = null;
    String publisher = null;

    public Book(String name, String desc, double price, String author, String isbn, String publisher) {
        super(name, desc, price);
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
    }
}
