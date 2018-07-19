package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<Book> bookList = new ArrayList<Book>();
    private ArrayList<Movie> movieList = new ArrayList<Movie>();


    public void fillBookList(Book book) {
        bookList.add(book);
    }

    public void fillMovieList(Movie movie) {
        movieList.add(movie);
    }

    public void setUp(){
        Book book1 = new Book("Narnia", "CS Lewis", "1920");
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1925");
        Book book3 = new Book("Harry Potter", "JK Rowling", "2003");

        fillBookList(book1);
        fillBookList(book2);
        fillBookList(book3);

        Movie movie1 = new Movie("Star Wars", "1977", "George Lucas", "7");
        Movie movie2 = new Movie("King Kong", "1984", "blah blah", "6");
        Movie movie3 = new Movie("Interstellar", "2014", "blah blah", "8");

        fillMovieList(movie1);
        fillMovieList(movie2);
        fillMovieList(movie3);
    }


    public void printBookList(){
        System.out.println("Title\tAuthor\tYear Published");
        for (Book book : bookList){
            if (book.isAvailable()) {
                System.out.print(book.getTitle() + "\t");
                System.out.print(book.getAuthor() + "\t");
                System.out.println(book.getYear());
            }
        }
    }

    public void printMovieList(){
        System.out.println("Title\tAuthor\tYear Published");
        for (Movie movie : movieList){
            if (movie.isAvailable()) {
                System.out.print(movie.getTitle() + "\t");
                System.out.print(movie.getYear() + "\t");
                System.out.print(movie.getDirector() + "\t");
                System.out.println(movie.getRating());
            }
        }
    }

    public void startBiblioteca(){
        System.out.print("Hello user!\n");
    }

    public void showMenuOptions(){
        System.out.println("Here are your options:");
        System.out.println("1. List all available books");
        System.out.println("2. Check out a book");
        System.out.println("3. Return a book");
        System.out.println("4. List all available movies");
        System.out.println("5. Check out a movie");
        System.out.println("6. Return a movie");
        System.out.println("0. Quit Biblioteca");
        System.out.println("Please select an option:");
    }

    public int getUserMenuChoice(){
        int userChoice = -1;
        Scanner input = new Scanner(System.in);
        userChoice = Integer.parseInt(input.nextLine());
        return userChoice;
    }

    public void selectUserMenuOption(int choice){
        if (choice == 1) {
            System.out.println("Available books in the library:");
            printBookList();
        }
        else if (choice == 2){
            System.out.println("Please enter the book title you wish to check out:");
            checkOutBook(getUserInputTitle());
        }
        else if (choice == 3){
            System.out.println("Please enter the book title you wish to return:");
            returnBook(getUserInputTitle());
        }
        else if (choice == 4) {
            System.out.println("Available movies in the library:");
            printMovieList();
        }
//        else if (choice == 5){
//            System.out.println("Please enter the movie title you wish to check out:");
//            checkOutBook(getUserInputTitle());
//        }
//        else if (choice == 6){
//            System.out.println("Please enter the movie title you wish to return:");
//            returnBook(getUserInputTitle());
//        }
        else if (choice == 0){
            return;
        }
        else {
            System.out.println("Invalid Option");
        }
    }

    public String getUserInputTitle(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }


    public boolean checkOutBook(String titleToCheckOut) {
        for (Book book : bookList) {
            if (book.getTitle().equals(titleToCheckOut) && book.isAvailable()) {
                book.setAvailability(false);
                System.out.println("Book checked out successfully!");
                return true;
            }
        }
        System.out.println("Invalid option. Please select a valid book title.");
        printBookList();
        return false;
    }


    public boolean returnBook(String titleToReturn) {
        for (Book book : bookList) {
            if (book.getTitle().equals(titleToReturn) && !book.isAvailable()) {
                book.setAvailability(true);
                System.out.println("Book returned successfully!");
                return true;
            }
        }
        System.out.println("Invalid option. Please input valid book title to return.");
        printBookList();
        return false;
    }
}
