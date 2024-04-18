package com.example.servicios.servicio3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> list() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @GetMapping("/search/{title}")
    public List<Book> searchByBookName(@PathVariable String title) {
        return bookRepository.findAllByTitle(title);
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable long id, @RequestBody Book book) {
        if (!bookRepository.existsById(id)) {
            return null;
        }
        Book bookTemp = book;
        bookTemp.setId(id);
        return bookRepository.save(bookTemp);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        bookRepository.deleteById(id);
    }

}
