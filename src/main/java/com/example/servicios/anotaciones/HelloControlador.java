package com.example.servicios.anotaciones;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControlador {

    // http://localhost:8080/hello
    @GetMapping("/hello")
    public String saludo() {
        return "Hola Mundo";
    }

    // http://localhost:8080/hello2?name=diego
    @GetMapping("/hello2")
    public String saludo2(@RequestParam(defaultValue = "Diego") String name) {
        return "Hola ".concat(name);
    }

    @GetMapping("/hello3")
    public String saludo3(@RequestParam(defaultValue = "Diego") String name) {
        return "Hola ".concat(name);
    }
}
