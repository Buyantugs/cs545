package edu.miu.lab5_part2.service;

import edu.miu.lab5_part2.data.BookRepository;
import edu.miu.lab5_part2.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void addBook(BookDTO bookDTO){

        Book book=BookAdapter.getBook(bookDTO);
        bookRepository.save(book);
    }

    public void updateBook(BookDTO bookDTO){

        Book book=BookAdapter.getBook(bookDTO);
        bookRepository.delete(book);
        bookRepository.save(book);
    }

    public void delete(String isbn){
        bookRepository.delete(bookRepository.findByIsbn(isbn));
    }

    public Book getBook(String isbn){
        return bookRepository.findByIsbn(isbn);

    }

    public Collection<BookDTO> findAll(){
        Collection<Book>  books=bookRepository.findAll();
        Collection<BookDTO> bookDTOs=new ArrayList<>();

        for (Book book : books){
            bookDTOs.add(BookAdapter.getBookDTO(book));
        }
        return bookDTOs;

    }

    public Collection<BookDTO> findBookByAuthor(String author){
       // return bookRepository.findByAuthor(author);

        Collection<Book>  books=bookRepository.findByAuthor(author);
        Collection<BookDTO> bookDTOs=new ArrayList<>();

        for (Book book : books){
            bookDTOs.add(BookAdapter.getBookDTO(book));
        }
        return bookDTOs;

    }

}
