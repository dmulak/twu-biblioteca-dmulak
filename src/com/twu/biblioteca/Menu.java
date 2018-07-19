package com.twu.biblioteca;

public class Menu {

    public void startBiblioteca(){
        System.out.print("Hello\n");
    }

    public void showMenuOptions(){
        System.out.println("1. List books");
        System.out.println("Please select an option");
    }

    public int getUserMenuChoice(){
         return 1;
    }

    public void selectUserMenuOption(int choice){
        if (choice == 1) {
        }
        else {
            System.out.println("Invalid Option");
        }
    }
}
