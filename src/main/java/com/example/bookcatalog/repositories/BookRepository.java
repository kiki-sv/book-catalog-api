package com.example.bookcatalog.repositories;

import com.example.bookcatalog.models.Book;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public List<Book> findByTitleContainingIgnoreCase(String title);
    public List<Book> findByAuthorContainingIgnoreCase(String author);
}


