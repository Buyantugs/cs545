package books.web;

import books.domain.Book;
import books.service.BookService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {

    @Autowired
    private BookService bookService;

    public Book createBook(final String isbn, final String title, final Double price, final String author) {
        Book book = new Book(isbn, title, price, author);
        bookService.add(book);
        return book;
    }
    public Book updateBook(final String isbn, final String title, final Double price, final String author) {
        Book book = new Book(isbn, title, price, author);
        bookService.update(book);
        return book;
    }

    public String deleteBook(final String isbn) {
        bookService.delete(isbn);
        return isbn;
    }

}
