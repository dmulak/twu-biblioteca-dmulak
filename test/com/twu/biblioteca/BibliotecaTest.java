package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotecaTest {
    private final ByteArrayOutputStream consoleStream = new ByteArrayOutputStream();
    private Menu menu = new Menu();
    private ArrayList<Book> bookList = new ArrayList<Book>();


    @Before
    public void setUp(){
        System.setOut(new PrintStream(consoleStream));
        Book book1 = new Book("Narnia", "CS Lewis", "1920");
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1925");
        Book book3 = new Book("Harry Potter", "JK Rowling", "2003");
        menu.fillBookList(book1);
        menu.fillBookList(book2);
        menu.fillBookList(book3);
    }

    @Test
    public void welcomeMessageTest() {
        menu.startBiblioteca();
        assertEquals("Hello user!\n", consoleStream.toString());
    }

    @Test
    public void testShowMenuOptions() {
        menu.showMenuOptions();
        assertTrue(consoleStream.toString().contains("List all available books"));
    }

    @Test
    public void testIncorrectUserInput() {
        menu.selectUserMenuOption(999);
        assertTrue(consoleStream.toString().contains("Invalid Option"));
    }

    @Test
    public void testCorrectUserInputShowsBookList() {
        menu.selectUserMenuOption(1);
        assertTrue(consoleStream.toString().contains("Narnia"));
        assertTrue(consoleStream.toString().contains("The Great Gatsby"));
        assertTrue(consoleStream.toString().contains("Harry Potter"));
    }

    @Test
    public void testWorkingUserInput() {
        ByteArrayInputStream input = new ByteArrayInputStream("1".getBytes());
        System.setIn(input);
        assertEquals(1, menu.getUserMenuChoice());
    }

    @Test
    public void testCheckedOutBookDoesNotAppearInList(){
        String titleToCheckOut = "Narnia";
        menu.checkOutBook(titleToCheckOut);
        menu.printBookList();
        assertFalse(consoleStream.toString().contains(titleToCheckOut));
    }

    @Test
    public void testCheckedOutBookCannotBeCheckedOutAgain(){
        String titleToCheckOut = "Narnia";
        menu.checkOutBook(titleToCheckOut);
        menu.checkOutBook(titleToCheckOut);
        assertTrue(consoleStream.toString().contains("Invalid"));
    }

    @Test
    public void testCannotCheckedOutInvalidTitle(){
        String incorrectTitleToCheckOut = "Marnia";
        menu.checkOutBook(incorrectTitleToCheckOut);
        assertTrue(consoleStream.toString().contains("Invalid"));
    }

    @Test
    public void testReturnedBookAppearsInList(){
        String titleToReturn = "Narnia";
        menu.checkOutBook(titleToReturn);
        menu.returnBook(titleToReturn);
        menu.printBookList();
        assertTrue(consoleStream.toString().contains(titleToReturn));
    }

    @Test
    public void testCannotReturnInvalidTitle(){
        String titleToCheckOut = "Narnia";
        String incorrectTitleToReturn = "Marnia";
        menu.checkOutBook(titleToCheckOut);
        menu.returnBook(incorrectTitleToReturn);
        assertTrue(consoleStream.toString().contains("Invalid"));
    }


}
