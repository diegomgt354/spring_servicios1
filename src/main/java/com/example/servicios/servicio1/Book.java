package com.example.servicios.servicio1;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {

    private static long id = 0;
    private String title;
    private float price;

    public Book(String title, float price) {
        this.title = title;
        this.price = price;
        id++;
    }

    public long getId() {
        return id;
    }

}
