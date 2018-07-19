package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<Book> bookList = new ArrayList<Book>();

    public void fillBookList(Book book) {
        bookList.add(book);
    }

    public void setUp(){
        Book book1 = new Book("Narnia", "CS Lewis", "1920");
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1925");
        Book book3 = new Book("Harry Potter", "JK Rowling", "2003");

        fillBookList(book1);
        fillBookList(book2);
        fillBookList(book3);
    }

    public void printBookList(){
        for (Book book : bookList){
            System.out.print(book.getTitle() + "\t");
            System.out.print(book.getAuthor() + "\t");
            System.out.println(book.getYear());
        }
    }

    public void startBiblioteca(){
        System.out.print("Hello\n");
    }

    public void showMenuOptions(){
        System.out.println("1. List books");
        System.out.println("Please select an option");
    }

    public int getUserMenuChoice(){
        int userChoice = -1;
        Scanner input = new Scanner(System.in);
        userChoice = Integer.parseInt(input.nextLine());
        return userChoice;
    }

    public void selectUserMenuOption(int choice){
        if (choice == 1) {
            printBookList();
        }
        else {
            System.out.println("Invalid Option");
        }
    }
}
