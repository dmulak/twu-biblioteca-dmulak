package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.setUp();
        menu.startBiblioteca();
        menu.showMenuOptions();

        User user = new User("anonymous", "anonymous", "anonymous@email.com", "00000");
        user.setPassword("password");

        int userChoice = -1;
        while (userChoice != 0) {
            userChoice = menu.getUserMenuChoice();
            menu.selectUserMenuOption(userChoice, user);
            if (userChoice != 0) menu.showMenuOptions();
        }

    }
}
