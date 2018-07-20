package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    private ArrayList<LibraryItem> bookList = new ArrayList<LibraryItem>();
    private ArrayList<LibraryItem> movieList = new ArrayList<LibraryItem>();


    private ArrayList<LibraryItem> fillInventory(ArrayList<LibraryItem> itemList, LibraryItem... items) {
        itemList.addAll(Arrays.asList(items));
        return itemList;
    }

    public ArrayList<LibraryItem> getBookList(){
        return bookList;
    }

    public ArrayList<LibraryItem> getMovieList(){
        return movieList;
    }


    public void setUp(){
        Book book1 = new Book("Narnia", "CS Lewis", "1920");
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1925");
        Book book3 = new Book("Harry Potter", "JK Rowling", "2003");

        Movie movie1 = new Movie("Star Wars", "1977", "George Lucas", "7");
        Movie movie2 = new Movie("King Kong", "1984", "blah blah", "6");
        Movie movie3 = new Movie("Interstellar", "2014", "blah blah", "8");


        fillInventory(bookList, book1, book2, book3);
        fillInventory(movieList, movie1, movie2, movie3);
    }


    private void printInventory(ArrayList<LibraryItem> itemList) {
        for (LibraryItem item : itemList){
            if (item.isAvailable()) {
                System.out.print(item.getTitle() + "\t");
                System.out.println(item.getYear());
            }
        }
    }

    public void printBookList(){
        printInventory(bookList);
    }

    public void printMovieList(){
        printInventory(movieList);
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
        else if (choice == 5){
            System.out.println("Please enter the movie title you wish to check out:");
            checkOutMovie(getUserInputTitle());
        }
        else if (choice == 6){
            System.out.println("Please enter the movie title you wish to return:");
            returnMovie(getUserInputTitle());
        }
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

    public void checkOutBook(String titleToCheckOut){
        checkOutItem(bookList, titleToCheckOut);
    }

    public void checkOutMovie(String titleToCheckOut){
        checkOutItem(movieList, titleToCheckOut);
    }

    public void returnBook(String titleToReturn){
        returnItem(bookList, titleToReturn);
    }

    public void returnMovie(String titleToReturn){
        returnItem(movieList, titleToReturn);
    }


    private boolean checkOutItem(ArrayList<LibraryItem> itemList, String titleToCheckOut) {
        for (LibraryItem item : itemList) {
            if (item.getTitle().equals(titleToCheckOut) && item.isAvailable()) {
                item.setAvailability(false);
                System.out.println("Item checked out successfully!");
                return true;
            }
        }
        System.out.println("Invalid option. Please select a valid title.");
        printInventory(itemList);
        return false;
    }


    private boolean returnItem(ArrayList<LibraryItem> itemList, String titleToReturn) {
        for (LibraryItem item : itemList) {
            if (item.getTitle().equals(titleToReturn) && !item.isAvailable()) {
                item.setAvailability(true);
                System.out.println("Item returned successfully!");
                return true;
            }
        }
        System.out.println("Invalid option. Please select a valid title to return to the library.");
        printInventory(itemList);
        return false;
    }
}
