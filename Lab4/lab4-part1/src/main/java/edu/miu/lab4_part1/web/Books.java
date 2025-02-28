package edu.miu.lab4_part1.web;

import edu.miu.lab4_part1.domain.Book;

import java.util.Collection;

public class Books {
    private Collection<Book> books;

    public Books(Collection<Book> books) {
        this.books = books;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
}
