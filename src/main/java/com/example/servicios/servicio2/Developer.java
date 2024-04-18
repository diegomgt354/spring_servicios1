package com.example.servicios.servicio2;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Developer {

    private long id;
    private String name;
    private int age;
    private ArrayList<String> language;

}
