package com.example.servicios.servicio1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

    public static List<Book> books = new ArrayList<>();

    BookController() {
        books.add(new Book("Piratas", 12f));
    }

    @GetMapping
    public List<Book> list() {
        return books;
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable long id) {
        return books.stream().filter(b -> id == b.getId()).findAny().orElse(null);
    }

    @GetMapping("/search/{title}")
    public List<Book> searchByBookName(@PathVariable String title) {
        return books.stream().filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase())).toList();
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        books.add(book);
        return books.get(books.size() - 1);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable long id, @RequestBody Book book) {
        Book bookTemp = books.stream().filter(b -> id == b.getId()).findAny().orElse(null);
        if (bookTemp == null) {
            return null;
        }
        bookTemp.setTitle(book.getTitle());
        bookTemp.setPrice(book.getPrice());
        return bookTemp;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        books.removeIf(b -> id == b.getId());
    }

}
