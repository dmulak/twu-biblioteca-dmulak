package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.setUp();
        menu.startBiblioteca();
        menu.showMenuOptions();

        int userChoice = -1;
        while (userChoice != 0) {
            userChoice = menu.getUserMenuChoice();
            menu.selectUserMenuOption(userChoice);
            if (userChoice != 0) menu.showMenuOptions();
        }

    }
}
