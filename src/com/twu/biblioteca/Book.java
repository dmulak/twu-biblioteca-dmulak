package com.twu.biblioteca;

public class Book extends LibraryItem{

    public Book(String title, String author, String year) {
        super(title, author, year);
    }

    @Override
    public String getDetails() {
        return String.format("|%20s|%20s|%5s|", getTitle(), getAuthor(), getYear());
    }

    public String getHeaders(){
        return String.format("|%20s|%20s|%5s|", "Title", "Author", "Year");
    }
}
