package edu.miu.lab4_part1.web;

import edu.miu.lab4_part1.domain.Book;
import edu.miu.lab4_part1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class BookController {
//    private Map<String, Book> books=new HashMap<>();
//
//    public BookController(){
//        books.put("isbn001", new Book("isbn001","John Doe","Java spring boot fundamentals",15.5));
//        books.put("isbn002", new Book("isbn002","Jack Water","Chigiss Khan conqure",25.5));
//        books.put("isbn003", new Book("isbn003","John Doe","Algorithm",13));
//    }

    @Autowired
    BookService bookService;


    @GetMapping("/getAllBooks")
    public ResponseEntity<?> getAllBooks(){
        Books allbooks= new Books(bookService.findAll());
        return new ResponseEntity<Books>(allbooks, HttpStatus.OK);
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn){
        Book book=bookService.getBook(isbn);
        if(book==null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn="+isbn+" is not available!"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PostMapping ("/books")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        bookService.addBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<?>deleteBook(@PathVariable String isbn){
        Book book=bookService.getBook(isbn);
        if(book==null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn="+isbn+" is not available!"),HttpStatus.NOT_FOUND);
        }
        bookService.delete(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<?> updateContact(@PathVariable String isbn, @RequestBody Book book){
        bookService.updateBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("/search/{author}")
    public ResponseEntity<?>searchBooks(@PathVariable String author){

       Collection<Book> listBook=bookService.findBookByAuthor(author);
        if(listBook==null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("The author="+author+" is not found!"),HttpStatus.NOT_FOUND);
        }

        Books allbooks=new Books(listBook);
        return new ResponseEntity<Books>(allbooks, HttpStatus.OK);
    }




}
