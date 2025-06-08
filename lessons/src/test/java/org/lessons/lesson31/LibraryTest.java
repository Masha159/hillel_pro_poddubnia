package org.lessons.lesson31;

import org.junit.Assert;
import org.junit.Test;

public class LibraryTest {
    Library library = new Library();
    Book validBook = new Book("Kobzar", "Shevchenko");

    @Test
    public void shouldTrowExceptionWhenAddingNullBook() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(null);
        });
    }

    @Test
    public void shouldTrowExceptionWhenAddingDuplicateBook() {
        library.addBook(validBook);
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(validBook);
        });
    }

    @Test
    public void shouldAddBookWhenValid() {
        library.addBook(validBook);
        Assert.assertTrue(library.getBooks().contains(validBook));
    }

    @Test
    public void shouldAddBookWhenMultipleBooks() {
        Book otherBook = new Book("Kobzar2", "Shevchenko");

        library.addBook(validBook);
        library.addBook(otherBook);

        Assert.assertTrue(library.getBooks().contains(validBook));
        Assert.assertTrue(library.getBooks().contains(otherBook));
    }

    @Test
    public void shouldRemoveBookWhenValid() {
        library.addBook(validBook);
        library.removeBook(validBook);
        Assert.assertFalse(library.getBooks().contains(validBook));
    }

    @Test
    public void shouldTrowExceptionWhenRemoveNullBook() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {library.removeBook(null);});
    }

    @Test
    public void shouldGetAllBooks() {
        library.addBook(validBook);
        Assert.assertTrue(library.getBooks().contains(validBook));
    }

    @Test
    public void shouldGetAllBooksCount() {
        library.addBook(validBook);
        Assert.assertEquals(1, library.getBookCount());
    }

    @Test
    public void shouldGetAllBooksCountWhenEmptyBooks() {
        Assert.assertEquals(0, library.getBookCount());
    }
}
