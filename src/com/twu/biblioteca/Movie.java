package com.twu.biblioteca;

public class Movie extends LibraryItem{

    public Movie(String title, String year, String director, String rating) {
        super(title, director, year, rating);
    }

    @Override
    public String getDetails() {
        return String.format("|%20s|%20s|%3s|%5s|", getTitle(), getDirector(), getRating(), getYear());
    }

    public String getHeaders(){
        return String.format("|%20s|%20s|%3s|%5s|", "Title", "Director", "Rating", "Year");
    }
}
