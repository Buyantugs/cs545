package edu.miu.lab5_part2.service;

import edu.miu.lab5_part2.domain.Book;

public class BookAdapter {

    public static Book getBook(BookDTO bookDTO){

        Book book=new Book();

        if(book!=null){
            book=new Book(
                    bookDTO.getIsbn(),
                    bookDTO.getAuthor(),
                    bookDTO.getTitle(),
                    bookDTO.getPrice()
            );
        }

        return book;
    }

    public  static  BookDTO getBookDTO(Book book){
        BookDTO bookDTO=new BookDTO();

        if(book!=null){
            bookDTO=new BookDTO(
                    book.getIsbn(),
                    book.getAuthor(),
                    book.getTitle(),
                    book.getPrice()
            );
        }

        return bookDTO;
    }
}
