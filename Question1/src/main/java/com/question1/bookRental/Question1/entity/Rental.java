package com.question1.bookRental.Question1.entity;
import jakarta.persistence.*;

import java.awt.geom.GeneralPath;
import java.time.LocalDateTime;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //Many Rentals can be assiciated with a single user
    @JoinColumn(name = "user_id", nullable = false) // Make sure this matches the column in the database
    private User user;

    @ManyToOne  //Many rental can be asscoiated to single book
    @JoinColumn(name = "book_id", nullable = false) // Make sure this matches the column in the database
    private  Book book;


    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isReturned;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {//is bok returned or nor
        isReturned = returned;
    }
}
