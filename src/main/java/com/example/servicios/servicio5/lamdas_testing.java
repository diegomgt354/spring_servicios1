package com.example.servicios.servicio5;

import java.util.ArrayList;
import java.util.List;

public class lamdas_testing {
    public static void main(String[] args) {

        List<String> nombres = List.of("diego", "fernando","alessio", "luis", "carmelo","condorito");
        nombres.stream().map("Marca de carro: "::concat).forEach(System.out::println);

        List<String> nombres2 = nombres.stream().filter(n->n.startsWith("c")).map(String::toUpperCase).toList();
        nombres2.forEach(System.out::println);
        
        List<String> nombres3 = new ArrayList<>();
        for (String nombre : nombres) {
            if (nombre.toUpperCase().startsWith("C")) {
                nombres3.add(nombre.toUpperCase());
            }
        }


        for(String name : nombres3){
            System.out.println(name);
        }



    }
}
