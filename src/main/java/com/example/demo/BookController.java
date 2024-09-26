package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        book.setStatus("received");
        books.add(book);
        return book;
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return books;
    }
}
