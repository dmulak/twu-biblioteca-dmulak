package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.setUp();
        menu.startBiblioteca();
        menu.showMenuOptions();

        menu.selectUserMenuOption(menu.getUserMenuChoice());
    }
}
