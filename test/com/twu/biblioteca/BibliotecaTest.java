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



    @Before
    public void setUp(){
        System.setOut(new PrintStream(consoleStream));
        menu.setUp();

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

    @Test
    public void testCorrectUserInputShowsMovieList() {
        menu.selectUserMenuOption(4);
        assertTrue(consoleStream.toString().contains("Star Wars"));
        assertTrue(consoleStream.toString().contains("King Kong"));
        assertTrue(consoleStream.toString().contains("Interstellar"));
    }

    @Test
    public void testCheckedOutMovieDoesNotAppearInList(){
        String titleToCheckOut = "King Kong";
        menu.checkOutMovie(titleToCheckOut);
        menu.printMovieList();
        assertFalse(consoleStream.toString().contains(titleToCheckOut));
    }

    @Test
    public void testCheckedOutMovieCannotBeCheckedOutAgain(){
        String titleToCheckOut = "King Kong";
        menu.checkOutMovie(titleToCheckOut);
        menu.checkOutMovie(titleToCheckOut);
        assertTrue(consoleStream.toString().contains("Invalid"));
    }

    @Test
    public void testCannotCheckOutInvalidMovieTitle(){
        String incorrectTitleToCheckOut = "Hong Kong";
        menu.checkOutMovie(incorrectTitleToCheckOut);
        assertTrue(consoleStream.toString().contains("Invalid"));
    }

    @Test
    public void testReturnedMovieAppearsInList(){
        String titleToReturn = "King Kong";
        menu.checkOutMovie(titleToReturn);
        menu.returnMovie(titleToReturn);
        menu.printMovieList();
        assertTrue(consoleStream.toString().contains(titleToReturn));
    }

    @Test
    public void testCannotReturnInvalidMovieTitle(){
        String titleToCheckOut = "King Kong";
        String incorrectTitleToReturn = "Hong Kong";
        menu.checkOutMovie(titleToCheckOut);
        menu.returnMovie(incorrectTitleToReturn);
        assertTrue(consoleStream.toString().contains("Invalid"));
    }


}
