package com.example.bookcatalog.controllers;

import com.example.bookcatalog.models.Book;
import com.example.bookcatalog.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.lang.Iterable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {


    private final BookRepository bookRepository;

    public BookController(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    @GetMapping()
    public Iterable<Book> getAllBooks() {
            return this.bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable("id") Integer id) {
        return this.bookRepository.findById(id);
    }

    @GetMapping("/search/title")
    public List<Book> findBooksByTitle(@RequestParam(name = "title", required = false) String title) {
        if (title != null && !title.isEmpty()) {
            return bookRepository.findByTitleContainingIgnoreCase(title);
        } else {
            return List.of();
        }
    }

    @GetMapping("/search/author")
    public List<Book> findBooksByAuthor(@RequestParam(name = "author", required = false) String author) {
        if (author != null && !author.isEmpty()) {
            return bookRepository.findByAuthorContainingIgnoreCase(author);
        } else {
            return List.of();
        }
    }

    @PostMapping
    public Book createNewBook(@RequestBody Book book) {
        return this.bookRepository.save(book);
    }

    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {
        Optional<Book> bookToUpdateOptional = this.bookRepository.findById(id);
        if (bookToUpdateOptional.isEmpty()) {
            return null;
        }

        Book bookToUpdate = bookToUpdateOptional.get();

        if(book.getTitle() != null) {
            bookToUpdate.setTitle(book.getTitle());
        }

        if(book.getAuthor() != null) {
            bookToUpdate.setAuthor(book.getAuthor());
        }

        if(book.getSummary() != null) {
            bookToUpdate.setSummary(book.getSummary());
        }

        if(book.getPublicationYear() != null) {
            bookToUpdate.setPublicationYear(book.getPublicationYear());
        }

        if(book.getGenre() != null) {
            bookToUpdate.setGenre(book.getGenre());
        }

        return this.bookRepository.save(bookToUpdate);

    }

    @DeleteMapping("/delete/{id}")
    public Book deleteBook(@PathVariable("id") Integer id) {
        Optional<Book> bookToDeleteOptional = this.bookRepository.findById(id);
        if(bookToDeleteOptional.isEmpty()) {
            return null;
        }

        Book bookToDelete = bookToDeleteOptional.get();
        this.bookRepository.delete(bookToDelete);
        return bookToDelete;
    }
}
