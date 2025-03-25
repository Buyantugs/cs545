package edu.miu.lab5_part2.web;

import edu.miu.lab5_part2.domain.Book;
import edu.miu.lab5_part2.service.BookDTO;
import edu.miu.lab5_part2.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Controller
public class BookController {

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

            //int q=1/0;

            if(book==null){
                return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn="+isbn+" is not available!"),HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PostMapping ("/books")
    public ResponseEntity<?> addBook(@Valid @RequestBody BookDTO bookDTO){

        try{
            //System.out.println("Controller=> "+book);
            bookService.addBook(bookDTO);

            return new ResponseEntity<BookDTO>(bookDTO, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<?>deleteBook(@PathVariable String isbn){
        Book book=bookService.getBook(isbn);
        if(book==null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn="+isbn+" is not available!"),HttpStatus.NOT_FOUND);
        }
        bookService.delete(isbn);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<?> updateContact(@PathVariable String isbn, @RequestBody BookDTO bookDTO){
        bookService.updateBook(bookDTO);
        return new ResponseEntity<BookDTO>(bookDTO, HttpStatus.OK);
    }

    @GetMapping("/search/{author}")
    public ResponseEntity<?>searchBooks(@PathVariable String author){

       Collection<BookDTO> listBook=bookService.findBookByAuthor(author);
        if(listBook==null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("The author="+author+" is not found!"),HttpStatus.NOT_FOUND);
        }

        Books allbooks=new Books(listBook);
        return new ResponseEntity<Books>(allbooks, HttpStatus.OK);
    }

    public ResponseEntity<Object> handleExceptions(Exception exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccess", false);
        map.put("error1", exception.getMessage());
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<Object>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
