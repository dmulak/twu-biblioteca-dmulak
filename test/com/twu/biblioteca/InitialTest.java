package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InitialTest {
    private final ByteArrayOutputStream consoleStream = new ByteArrayOutputStream();
    private Menu menu = new Menu();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(consoleStream));
    }

    @Test
    public void welcomeMessageTest() {
        menu.startBiblioteca();
        assertEquals("Hello\n", consoleStream.toString());
    }

    @Test
    public void testShowMenuOptions() {
        menu.showMenuOptions();
        assertTrue(consoleStream.toString().contains("List books"));
    }

    @Test
    public void testIncorrectUserInput() {
        menu.selectUserMenuOption(999);
        assertTrue(consoleStream.toString().contains("Invalid Option"));
    }




}
