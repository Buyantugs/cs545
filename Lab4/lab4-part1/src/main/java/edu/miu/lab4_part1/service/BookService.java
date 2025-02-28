package edu.miu.lab4_part1.service;

import edu.miu.lab4_part1.data.BookRepository;
import edu.miu.lab4_part1.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Book book){
        bookRepository.update(book);
    }

    public void delete(String isbn){
        bookRepository.delete(isbn);
    }

    public Book getBook(String isbn){
        return bookRepository.findBook(isbn);
    }

    public Collection<Book> findAll(){
        return bookRepository.findAll();
    }

    public Collection<Book> findBookByAuthor(String author){
        return bookRepository.searchBooksByAuthor(author);
    }

}
