package org.lessons.lesson31;

import java.util.ArrayList;
import java.util.List;

public class Library {


    private final List<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        if (!books.contains(book) && book != null) {
            books.add(book);
        } else {
            throw new IllegalArgumentException("invalid book");
        }
    }

    public boolean removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("invalid book");
        }
        return books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getBookCount() {
        return books.size();
    }
}
