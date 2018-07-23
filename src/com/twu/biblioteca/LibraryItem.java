package com.twu.biblioteca;

public class LibraryItem {
    private String title;
    private String author;
    private String director;
    private String rating;
    private String year;
    private boolean isAvailable;

    public LibraryItem(String title, String author, String year){
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
    }

    public LibraryItem(String title, String director, String year, String rating){
        this.title = title;
        this.director = director;
        this.rating = rating;
        this.year = year;
        this.isAvailable = true;
    }

    public String getDetails(){
        return title + "\t" + author + "\t" + director + "\t" + rating + "\t" + year;
    }

    public String getHeaders(){
        return "Title\tAuthor\tDirector\tRating\tYear";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }

    public String getYear() {
        return year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean available) {

        isAvailable = available;
    }
}
