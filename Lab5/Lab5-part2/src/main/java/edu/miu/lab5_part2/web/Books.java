package edu.miu.lab5_part2.web;

import edu.miu.lab5_part2.domain.Book;
import edu.miu.lab5_part2.service.BookDTO;

import java.util.Collection;

public class Books {
    private Collection<BookDTO> books;

    public Books(Collection<BookDTO> books) {
        this.books = books;
    }

    public Collection<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(Collection<BookDTO> books) {
        this.books = books;
    }
}
