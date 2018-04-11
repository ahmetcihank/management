package com.sft.management.Models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="demo")
public class Book {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;


    @Column(name= "book_name")
    private String bookName;

    @Column(name="author")
    private String author;

    @Column(name ="puchase_date")
    private Date purchaseDate;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Book(String bookName, String author, Date purchaseDate) {
        this.bookName = bookName;
        this.author = author;
        this.purchaseDate = purchaseDate;
    }

    public Book(){}
}
