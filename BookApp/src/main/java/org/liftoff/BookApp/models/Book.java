package org.liftoff.BookApp.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;

@Entity
public class Book extends AbstractEntity {

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String genre;

    public Book(){}

    public Book(String title,String author,String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }
}
