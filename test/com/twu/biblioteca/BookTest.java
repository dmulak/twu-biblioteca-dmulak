package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    
    private Book book = new Book("Narnia", "CS Lewis", "1920");

    @Test
    public void testBook() {
        assertEquals("Narnia", book.getTitle());
        assertEquals("CS Lewis", book.getAuthor());
        assertEquals("1920", book.getYear());
    }
}
