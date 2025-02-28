package edu.miu.lab4_part1.data;


import edu.miu.lab4_part1.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BookRepository {
    private Map<String, Book> books=new HashMap<>();


    public Collection<Book> findAll(){
        return books.values();
    }

    public Book findBook(String isbn){
        return books.get(isbn);
    }

    public Collection<Book> searchBooksByAuthor(String author) {
        return books.values().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public Collection<Book> findByAuthor(String author){
        return searchBooksByAuthor(author);
    }

    public void save(Book book){
        books.put(book.getIsbn(), book);
    }

    public void update(Book book){
        books.remove(book.getIsbn());
        books.put(book.getIsbn(), book);
    }

    public void delete(String isbn){
        books.remove(isbn);
    }



}
