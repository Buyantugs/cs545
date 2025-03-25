package edu.miu.lab5_part2.data;


import edu.miu.lab5_part2.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {

    Book findByIsbn(String isbn);
    List<Book> findByAuthor(String author);

}
